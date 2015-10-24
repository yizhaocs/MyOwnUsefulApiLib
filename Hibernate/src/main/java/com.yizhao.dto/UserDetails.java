package main.java.com.yizhao.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by YZ on 10/23/15.
 */
@Entity (name="USER_DETAILS") // create a database table name as "USER_DETAILS" instead of "UserDetails"
public class UserDetails {
    @Id // Id annotation is for the primary key only
    @Column(name="USER_ID") // set the field name as "USER_ID" instead of "userId"
    private int userId;

    @Column(name="USER_NAME") // set the field name as "USER_NAME" instead of "userName"
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
