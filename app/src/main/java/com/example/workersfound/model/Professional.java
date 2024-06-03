package com.example.workersfound.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Professional implements Serializable {

    private Integer professionalId;
    private Integer img;
    private String name;
    private String companyName;
    private String typeOfService;
    private Address address;
    private ArrayList<ProfessionalService> servicos = new ArrayList<>();
    private ArrayList<Schedule> schedules = new ArrayList<>();

    public Professional(Integer professionalId, Integer img, String name, String companyName, String typeOfService, Address address) {
        this.professionalId = professionalId;
        this.img = img;
        this.name = name;
        this.companyName = companyName;
        this.typeOfService = typeOfService;
        this.address = address;
    }
    public Integer getProfessionalId() {
        return professionalId;
    }
    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public Address getAddres() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<ProfessionalService> getServicos() {
        return servicos;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

}
