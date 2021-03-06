package com.ikramdg.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

@Entity
@Table(name = "t_instructor")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instructor extends BaseSchoolStaff {

    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToMany(mappedBy = "instructor")
    private Set<Course> instructedCourses = new HashSet<>();

    public Instructor(String fullName, Address address, String phoneNumber) {
        super(fullName, address);
        this.phoneNumber = phoneNumber;
    }

    public Instructor() {}


    public void addInstructedCourse(Course course) {
        instructedCourses.add(course);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Course> getInstructedCourses() {
        return instructedCourses;
    }

    public void setInstructedCourses(Set<Course> instructedCourses) {
        this.instructedCourses = instructedCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(instructedCourses, that.instructedCourses) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), phoneNumber);
    }

    @Override
    public String toString() {
        return  super.toString() +
                "phoneNumber='" + phoneNumber + '\'' +
                ", instructedCourses=" + instructedCourses;
    }
}
