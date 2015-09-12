package main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yizhao on 6/24/15.
 */
@Component("componentA")
public class ComponentA {
    @Autowired
    private ComponentB componentB;


    public void print(){
        System.out.println(componentB.getName());
    }
}
