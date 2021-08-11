package com.ikramdg.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

@Entity
@Table(name = "t_instructor")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instructor extends BaseSchoolStuff {


    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "instructor")
    private Set<Course> instructedCourses = new HashSet<>();

    public Instructor(String fullName, Address address, String phoneNumber) {
        super(fullName, address);
        this.phoneNumber = phoneNumber;
    }

    public Instructor() {}

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern validPattern = Pattern.compile("^\\d{10}$");
        return validPattern.matcher(phoneNumber).matches();

    }

    public void addInstructedCourse(Course course) {
        instructedCourses.add(course);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!isValidPhoneNumber(phoneNumber)) throw new RuntimeException("Invalid Phone Number");
        this.phoneNumber = phoneNumber;
    }

    public Set<Course> getInstructedCourses() {
        return instructedCourses;
    }

    public void setInstructedCourses(Set<Course> instructedCourses) {
        this.instructedCourses = instructedCourses;
    }


}
