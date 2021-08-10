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

    public VisitingResearcher(String name, String phoneNumber, Address address, Set<Course> instructedCourses, int hoursWorked) {
        super(name, phoneNumber, address, instructedCourses);
        this.hoursWorked = hoursWorked;
    }

    public VisitingResearcher() {}

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
