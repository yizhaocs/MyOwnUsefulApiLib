package com.yizhao.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by YZ on 10/23/15.
 */
@Entity
public class Employees {
    @Id
    private int empid;
    private String name;
    private int supervisor;
    private String location;
    private int salary;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
