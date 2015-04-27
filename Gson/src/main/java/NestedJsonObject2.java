package main.java;

/**
 * Created by yizhao on 4/27/15.
 */
public class NestedJsonObject2 {

    public User user;

    public NestedJsonObject2(String firstName, String lastName, String email, String password){
        user = new User(firstName, lastName , email, password);
    }

    class User {

        public String firstName;
        public String lastName;
        public String email;
        public String password;

        public User(String firstName, String lastName, String email, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
        }
    }
}
