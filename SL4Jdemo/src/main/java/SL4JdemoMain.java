package main.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yizhao on 5/11/15.
 */
public class SL4JdemoMain {
    private static final Logger logger = LoggerFactory.getLogger(SL4JdemoMain.class);

    public static void main(String[] args){
        logger.info("Hello world.");

        int result = sum(2, 2);
        System.err.println("2 + 2 = " + result);
    }

    public static int sum(int a, int b){
        return a + b;
    }
}
