package com.ikramdg.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;


@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "studentId"))
@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private Address address;
    @Enumerated
    private Gender gender;

    @ManyToMany
    @JoinTable(name = "t_student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;



}
