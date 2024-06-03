package com.example.workersfound.model;

import java.io.Serializable;

public class Address implements Serializable {

    private Integer addressId;
    private String city;
    private String district;
    private String state;
    private String streetName;
    private String houseNumber;

    public Address(int addressId, String city, String district, String state, String streetName, String houseNumber) {
        this.addressId = addressId;
        this.city = city;
        this.district = district;
        this.state = state;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
