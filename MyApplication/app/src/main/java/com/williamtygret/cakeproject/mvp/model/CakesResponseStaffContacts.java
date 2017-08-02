package com.williamtygret.cakeproject.mvp.model;

public class CakesResponseStaffContacts {
    private int id;
    private String dateOfBirth;
    private String[] email;
    private String name;
    private String role;
    private CakesResponseStaffContactsPhones phones;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String[] getEmail() {
        return this.email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public CakesResponseStaffContactsPhones getPhones() {
        return this.phones;
    }

    public void setPhones(CakesResponseStaffContactsPhones phones) {
        this.phones = phones;
    }
}
