import Context.ApplicationContext;
import TestUseClass.HelloFactory;
import org.junit.Test;

import java.util.List;

public class ApplicationContextTest {
    @Test
    public void Test() throws ClassNotFoundException {
        ApplicationContext context = new ApplicationContext(System.getProperty("user.dir"));
        try {
            System.out.println("------------");
            HelloFactory helloFactory = (HelloFactory) context.getBean("TestUseClass.HelloFactory");
            helloFactory.sayHello();
            System.out.println("------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
