package DesignPatterns;

/**
 * Created by yizhao on 12/18/14.
 */
public class SingletonPattern {
    private static SingletonPattern instance = null;

    private SingletonPattern() {

    }

    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }

}
