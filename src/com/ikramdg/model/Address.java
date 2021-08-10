package com.ikramdg.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    @Column(name = "zip_code", table = "t_address")
    private String zipCode;
    @Column(name = "state", table = "t_address")
    private String state;
    @Column(name = "city", table = "t_address")
    private String city;
    @Column(name = "street", table = "t_address")
    private String street;
    @Column(name = "house_number", table = "t_address")
    private int houseNumber;


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && Objects.equals(zipCode, address.zipCode) && Objects.equals(state, address.state) && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode, state, city, street, houseNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + zipCode + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
