package main.java.com.yizhao.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by YZ on 10/23/15.
 */
@Entity
public class UserDetails {
    @Id // Id annotation is for the primary key only
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
