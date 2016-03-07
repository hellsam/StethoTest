package com.hellsam.stethotest.db.model;

/**
 * Created by binshenchen on 16/2/26.
 */
public class User {
    private long id;
    private String name;
    private String phone;

    public User() {

    }

    public User(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
