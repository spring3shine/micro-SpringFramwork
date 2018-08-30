package Bean;

public class BeanDefinition {
    private Object bean;
    private Class beanClass;
    private String beanName;
    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition(Object bean, Class beanClass, String beanName) {
        this.bean = bean;
        this.beanClass = beanClass;
        this.beanName = beanName;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
