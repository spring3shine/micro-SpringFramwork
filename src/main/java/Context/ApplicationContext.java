package Context;

import Annotion.MyBean;
import Bean.BeanDefinition;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public List<String> className = new ArrayList<String>();
    public ApplicationContext(String path){
        loadClassName(path);
        System.out.println("---we have there class in the project:---");
        for (String name : className) {
            System.out.println(name);
        }System.out.println("-----------------");
        try {
            regist(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void regist(List<String> className) throws ClassNotFoundException {
        for (String name : className) {
            Class clazz = Class.forName(name);
            Annotation annotation = clazz.getAnnotation(MyBean.class);
            if (annotation != null) {
                BeanDefinition beanDefinition = new BeanDefinition(null, clazz, name);
                beanDefinitionMap.put(name, beanDefinition);
            }
        }
    }

    private void loadClassName(String path){
        File file = new File(path);
        File[] childrenFiles = file.listFiles();
        if(path.startsWith(".")) return;
        for (File child : childrenFiles) {
            String childPath = child.getPath();
            if (child.isDirectory()) {
                loadClassName(childPath);
            } else  {
                if (childPath.endsWith(".class") && childPath.indexOf("test-classes")==-1) {
                    childPath = childPath.substring(childPath.indexOf("\\classes") + 9, childPath.lastIndexOf("."));
                    childPath = childPath.replace("\\", ".");
                    className.add(childPath);
                }
            }
        }
    }

    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        return beanDefinition.getBeanClass().newInstance();
    }
}
