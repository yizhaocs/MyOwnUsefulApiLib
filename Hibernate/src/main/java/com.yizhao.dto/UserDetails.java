package main.java.com.yizhao.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by YZ on 10/23/15.
 */
@Entity
@Table(name = "USER_DETAILS") // ask Hibernate api to create a database table name as "USER_DETAILS" instead of "UserDetails"
public class UserDetails {
    @Id // ask Hibernate api to set this field as the primary key in the database table
    @Column(name = "USER_ID") // ask Hibernate api to set the field name as "USER_ID" instead of "userId"
    private int userId;

    @Column(name = "USER_NAME") // ask Hibernate api to set the field name as "USER_NAME" instead of "userName"
    private String userName;

    @Column(name = "JOINED_DATE_TIME")
    private Date joinedDateTime; // save both Data and time as "2015-10-23 20:51:23"

    @Temporal(TemporalType.DATE) // ask Hibernate api to save Data only as "2015-10-23"
    @Column(name = "JOINED_DATE")
    private Date joinedDate;

    @Temporal(TemporalType.TIME) // ask Hibernate api to save Time only as "20:51:23"
    @Column(name = "JOINED_TIME")
    private Date joinedTime;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DESCRIPTION")
    private String description;

    @Transient // ask Hibernate api to skip this field adding to the table
    @Column(name = "TEMP_FIELD")
    private String tempField;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getJoinedDateTime() {
        return joinedDateTime;
    }

    public void setJoinedDateTime(Date joinedDateTime) {
        this.joinedDateTime = joinedDateTime;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Date getJoinedTime() {
        return joinedTime;
    }

    public void setJoinedTime(Date joinedTime) {
        this.joinedTime = joinedTime;
    }

    public String getTempField() {
        return tempField;
    }

    public void setTempField(String tempField) {
        this.tempField = tempField;
    }
}
