package main.java;

/**
 * Reference: http://www.javabeat.net/how-to-lazy-initialize-spring-beans/
 */
public class Address {
    public Address() {
        System.out.println("Address Constructor");
    }

    private String street;
    private String city;
    private String pincode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
