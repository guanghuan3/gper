package com.guanghuan3.homework.myspringframework.beans.support;

import com.guanghuan3.homework.myspringframework.annotation.MyController;
import com.guanghuan3.homework.myspringframework.annotation.MyService;
import com.guanghuan3.homework.myspringframework.beans.config.MyBeanDefinition;
import com.guanghuan3.homework.myspringframework.utils.MyStringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator
 * on 2019/4/18.
 */
public class MyBeanDefinitionReader {

    public static final String SCAN_PACKAGE = "scanPackage";

    private Properties prop = new Properties();

    private List<String> registerBeanClasses = new ArrayList<String>();

    public MyBeanDefinitionReader(String... configLocations) {
        for (String location : configLocations) {
            InputStream is = MyBeanDefinition.class.getClassLoader().getResourceAsStream(location.replaceAll("classpath:", ""));
//            InputStream is = MyBeanDefinition.class.getResourceAsStream(location.replaceAll("classpath:", ""));
            try {
                prop.load(is);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.err.println(prop);
            doScanner(prop.getProperty(SCAN_PACKAGE));
        }
    }

    /**
     * 将有注释的类扫描进来
     * @param scanPackage
     */
    private void doScanner(String scanPackage) {
        // web场景下使用
//        URL url = MyBeanDefinitionReader.class.getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        // client场景下使用
        URL url = MyBeanDefinitionReader.class.getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classpath = new File(url.getFile());

        File[] files = classpath.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                // 递归获取文件夹下的内容
                doScanner(scanPackage + "." + f.getName());
            } else {
                if (f.getName().endsWith(".class")) {
                    String className = scanPackage + "." + f.getName().replace(".class", "");
                    registerBeanClasses.add(className);
                }
            }
        }
    }

    public List<MyBeanDefinition> loadBeanDefinitions() {
        List<MyBeanDefinition> beanDefinitionsList = new ArrayList<MyBeanDefinition>();

        if (registerBeanClasses != null && registerBeanClasses.size() > 0) {
            for (String className : registerBeanClasses) {
                try {
                    MyBeanDefinition definition = doCreateBeanDefinition(className);
                    if (definition == null) {
                        continue;
                    }
                    beanDefinitionsList.add(definition);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return beanDefinitionsList;
    }

    private MyBeanDefinition doCreateBeanDefinition(String className) {
        MyBeanDefinition beanDefinition = null;
        try {
            Class beanClass = Class.forName(className);
            if (!beanClass.isInterface()) {
                if (!containsAnnotation(beanClass)) {
                    return beanDefinition;
                }

                beanDefinition = new MyBeanDefinition();
                beanDefinition.setBeanClassName(className);
                beanDefinition.setFactoryBeanName(MyStringUtils.toFirstLowerCase((beanClass.getSimpleName())));
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return beanDefinition;
    }

    private boolean containsAnnotation(Class beanClass) {
        if (beanClass != null) {
            return beanClass.getAnnotation(MyController.class) != null || beanClass.getAnnotation(MyService.class) != null;
        }
        return false;
    }

    public Properties getProp() {
        return prop;
    }

//    public static void main(String[] args) {
//        new MyBeanDefinitionReader("classpath:application.properties");
//    }

}
