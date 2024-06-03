package com.example.workersfound.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Service implements Serializable {

    private Integer serviceId;
    private Integer img;
    private String name;
    private Integer color;
    private ArrayList<Professional> professionals = new ArrayList<>();

    public Service(int serviceId, Integer img, String name, Integer color) {
        this.serviceId = serviceId;
        this.img = img;
        this.name = name;
        this.color = color;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public ArrayList<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(ArrayList<Professional> professionals) {
        this.professionals = professionals;
    }
}
