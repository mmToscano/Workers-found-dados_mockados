package com.example.workersfound.model;

import java.io.Serializable;

public class ProfessionalService implements Serializable {

    private Integer professionalServiceId;
    private Professional professional;
    private String type;
    private Double price;

    public ProfessionalService(Integer professionalServiceId, Professional professional, String type, Double price) {
        this.professionalServiceId = professionalServiceId;
        this.professional = professional;
        this.type = type;
        this.price = price;
    }

    public Integer getProfessionalServiceId() {
        return professionalServiceId;
    }

    public void setProfessionalServiceId(Integer professionalServiceId) {
        this.professionalServiceId = professionalServiceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
