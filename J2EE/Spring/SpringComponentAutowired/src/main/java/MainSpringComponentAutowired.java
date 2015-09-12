package main.java;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yizhao on 6/24/15.
 */
public class MainSpringComponentAutowired {
    public static void main(String[] args){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComponentA mComponentA = (ComponentA)ctx.getBean("componentABean");
        mComponentA.print();
    }
}
