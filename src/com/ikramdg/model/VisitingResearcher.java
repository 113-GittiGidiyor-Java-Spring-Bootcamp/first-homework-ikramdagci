package com.ikramdg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "t_visiting_researcher")
public class VisitingResearcher extends Instructor{

    @Column(name = "hours_worked")
    private int hoursWorked;
    private static final double hourlySalary = 205.0;


    public VisitingResearcher(String fullName, Address address, String phoneNumber, int hoursWorked) {
        super(fullName, address, phoneNumber);
        this.hoursWorked = hoursWorked;
    }

    public VisitingResearcher() {}

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double calculateTotalSalary() {
        return hoursWorked * hourlySalary;
    }


    @Override
    public String toString() {
        return "VisitingResearcher{" +
                super.toString() +
                "hoursWorked=" + hoursWorked +
                "}";
    }
}
