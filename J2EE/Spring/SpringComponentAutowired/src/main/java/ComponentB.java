package main.java;

import org.springframework.stereotype.Component;

/**
 * Created by yizhao on 6/24/15.
 */
@Component("componentB")
public class ComponentB {
    String name = "yizhao";

    public String getName() {
        return name;
    }
}
