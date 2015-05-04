package main.java;

/**
 * Created by yizhao on 5/4/15.
 */
public class Employee {
    private String name;
    private String empId;
    private Address address;

    public Employee() {
        System.out.println("Employee Constructor");
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}