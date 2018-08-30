package TestUseClass;

import Annotion.MyBean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@MyBean()
public class HelloFactory {
    String personA ;
    String personB ;

    public void sayHello() {
        personA = "a";
        personB = "b";
        System.out.println(personA + " say hello to " + personB);
    }
}
