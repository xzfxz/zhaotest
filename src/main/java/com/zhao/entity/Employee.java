package com.zhao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhao on 2016/4/17.
 */
public class Employee implements Serializable{
    private static final long serialVersionUID = -8036096287977036275L;
    private String name;
    private long id;
    private double salary;
    private Date comedate;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                ", comedate=" + comedate +
                '}';
    }

    public Employee(String name, long id, double salary, Date comedate) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.comedate = comedate;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getComedate() {
        return comedate;
    }

    public void setComedate(Date comedate) {
        this.comedate = comedate;
    }
}
