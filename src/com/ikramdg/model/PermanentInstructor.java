package com.ikramdg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "t_permanent_instructor")
public class PermanentInstructor extends Instructor{

     @Column(name = "salary")
    private double salary;

    public PermanentInstructor(String name, String phoneNumber, Address address, Set<Course> instructedCourses, double salary) {
        super(name, phoneNumber, address, instructedCourses);
        this.salary = salary;
    }

    public  PermanentInstructor(){}

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "salary=" + salary +
                super.toString();
    }
}
