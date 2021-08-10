package com.ikramdg.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import java.time.LocalDate;


@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "studentId"))
@Entity
@Table(name = "t_student")
public class Student {

    private Integer studentId;
    private String fullName;
    private LocalDate birthDate;
    private Address address;
    private Gender gender;
//    private Set<Course> courses;

}
