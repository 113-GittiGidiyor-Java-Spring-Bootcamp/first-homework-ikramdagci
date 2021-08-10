package com.ikramdg.model;

import javax.persistence.*;
import java.util.HashSet;
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

}
