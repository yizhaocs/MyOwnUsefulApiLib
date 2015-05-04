package main.java;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yizhao on 5/4/15.
 */
public class MainLazyInit {
    public static void main(String args[]) {
        //Initializing context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( new String[]{"applicationContext.xml"});
        System.out.println("After initialization");
        applicationContext.getBean("addressBean");
    }
}
