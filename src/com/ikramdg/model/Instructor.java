package com.ikramdg.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_instructor")
@Inheritance(strategy = InheritanceType.JOINED)
@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "instructor_id"))
public abstract class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    @Column(name = "name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;

    private Address address;

    @OneToMany(mappedBy = "instructor")
    private Set<Course> instructedCourses = new HashSet<>();

    public Instructor(String name, String phoneNumber, Address address, Set<Course> instructedCourses) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.instructedCourses = instructedCourses;
    }

    public Instructor() {}



    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        Instructor that = (Instructor) o;
        return Objects.equals(instructorId, that.instructorId) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructorId, phoneNumber);
    }

    @Override
    public String toString() {
        return ", instructorId=" + instructorId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                ", instructedCourses=" + instructedCourses +
                '}';
    }
}
