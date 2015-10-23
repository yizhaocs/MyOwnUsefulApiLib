import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Reference: http://www.javabeat.net/how-to-lazy-initialize-spring-beans/
 */
public class MainLazyInit {
    public static void main(String args[]) {
        //Initializing context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( new String[]{"applicationContext.xml"});
        System.out.println("After initialization");
        applicationContext.getBean("addressBean");
    }
}
