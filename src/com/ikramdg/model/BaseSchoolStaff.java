package com.ikramdg.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_school_staff")
@Inheritance(strategy = InheritanceType.JOINED)
@SecondaryTable(name = "t_address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "staff_id"))
public abstract class BaseSchoolStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Long staffId;
    @Column(name = "full_name")
    private String fullName;
    @Embedded
    private Address address;

    public BaseSchoolStaff(String fullName, Address address) {
        this.fullName = fullName;
        this.address = address;
    }

    public BaseSchoolStaff() {}

    public Long getStuffId() {
        return staffId;
    }

    public void setStuffId(Long stuffId) {
        this.staffId = stuffId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseSchoolStaff that = (BaseSchoolStaff) o;
        return Objects.equals(staffId, that.staffId) && Objects.equals(fullName, that.fullName) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, fullName, address);
    }

    @Override
    public String toString() {
        return "staffId=" + staffId +
                ", fullName='" + fullName + '\'' +
                ", address=" + address;
    }
}
