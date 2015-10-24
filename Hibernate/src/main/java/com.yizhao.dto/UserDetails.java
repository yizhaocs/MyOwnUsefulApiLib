package main.java.com.yizhao.dto;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by YZ on 10/23/15.
 */
@Entity
@Table(name = "USER_DETAILS") // ask Hibernate api to create a database table name as "USER_DETAILS" instead of "UserDetails"
public class UserDetails {
    /*
        Reference: http://stackoverflow.com/questions/20603638/what-is-the-use-of-annotations-id-and-generatedvaluestrategy-generationtype
        The @Idannotation inherited from javax.persistence.Id， indicating the member field below is the primary key of current entity. Hence you Hibernate and spring framework as well as you can do some reflect work based on this annotation. for details please check javadoc for Id

        As for @GeneratedValue annotation, which the increase type for auto increment column, In the situation of Mysql, you may specify auto_increment in the definition of table to make it self-incremented. and the @GeneratedValue(strategy = GenerationType.IDENTITY) denote in the Java code, you also acknowledged to use this database side strategy. Also， you may change the value in this annotation, for instance, when I use Oracle as database, the @GeneratedValue should be like this:

        class MyTable
        {
            @Id
            @SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
            @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
            private Integer pid;
        }
        In the code above, you need to create sequence seq; in Oracle ahead.
        Then specify this seq in @SequenceGenerator annotation as shown above.
        and Finally, just add @GeneratedValue annotation like above.
        Please note the field generator is not the real sequence defined in oracle, but in which @SequenceGenerator defined.

        After using annotation in JavaWeb development, you might feel it is easy to configure and ORM setting.
    */
    @Id // ask Hibernate api to set this field as the primary key in the database table
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ElementCollection // ask Hibernate api to treat "listOfHomeAddresses" object as a collection
    private Set<Address> listOfHomeAddresses = new HashSet<>();

    @Embedded
    private Address address;

    @Embedded // ask Hibernate api to Embed Address object into table
    @AttributeOverrides({ // ask Hibernate api to override the field names in Address object
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
            @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "HOME_PIN_CODE"))})
    private Address homeAddress;

    @Embedded // ask Hibernate api to Embed Address object into table
    @AttributeOverrides({ // ask Hibernate api to override the field names in Address object
            @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY_NAME")),
            @AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE_NAME")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "OFFICE_PIN_CODE"))})
    private Address officeAddress;

    @Lob // ask Hibernate api to no to restrict this object to 255 chars limit, so it can be a very long string with @Lob annotation .
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Address> getListOfHomeAddresses() {
        return listOfHomeAddresses;
    }

    public void setListOfHomeAddresses(Set<Address> listOfHomeAddresses) {
        this.listOfHomeAddresses = listOfHomeAddresses;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
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
