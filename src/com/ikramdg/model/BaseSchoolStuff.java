package com.ikramdg.model;


import javax.persistence.*;

@Entity
@Table(name = "school_stuff")
@Inheritance(strategy = InheritanceType.JOINED)
@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "stuff_id"))
public abstract class BaseSchoolStuff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stuff_id")
    private Long stuffId;
    @Column(name = "full_name")
    private String fullName;
    private Address address;

    public BaseSchoolStuff(String fullName, Address address) {
        this.fullName = fullName;
        this.address = address;
    }

    public BaseSchoolStuff() {}

    public Long getStuffId() {
        return stuffId;
    }

    public void setStuffId(Long stuffId) {
        this.stuffId = stuffId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
