package main.java;

/**
 * Created by yizhao on 5/4/15.
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
