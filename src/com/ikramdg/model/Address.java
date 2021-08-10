package com.ikramdg.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
}
