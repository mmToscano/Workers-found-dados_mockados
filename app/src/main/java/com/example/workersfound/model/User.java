package com.example.workersfound.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private Integer userId;
    private String email;
    private String senha; //String porque isso aqui é senha. valores que não serão utilizados para operações matemáticas devem ser string, mesmo que sejam uma sequência de números
    private String nome;
    private Address address;
    private String phoneNumber;
    private ArrayList<Schedule> schedules = new ArrayList<>();

    public User(Integer userId, String email, String senha, String nome, Address address, String phoneNumber) {
        this.userId = userId;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
