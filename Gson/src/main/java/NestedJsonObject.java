package main.java;

/**
 * Created by yizhao on 4/27/15.
 */
public class NestedJsonObject {
    public User user = new User();

    class User {

        public String firstName="Yi";
        public String lastName="Zhao";
        public String email="yizhao.cs@gmail.com";
        public String password="123456";

        public User() {
            // No args constructor for B
        }
    }
}
