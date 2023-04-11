package com.rgxz.ecp.entity;

import java.sql.Timestamp;

public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String address;
    private String phone;
    private Float balance = 0F;
    private String gender = "保密";
    private String image_url = "src/main/webapp/image/user_head_image/default.jpg";
    private Integer identity = 0;
    private Integer business_id = null;
    private Timestamp create_time = null;

    public User(){}

    public User(Integer id, String name, String pwd, String address, String phone, Float balance, String gender, String image_url, Integer identity, Integer business_id, Timestamp create_time) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
        this.gender = gender;
        this.image_url = image_url;
        this.identity = identity;
        this.business_id = business_id;
        this.create_time = create_time;
    }

    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", gender='" + gender + '\'' +
                ", image_url='" + image_url + '\'' +
                ", identity=" + identity +
                ", business_id=" + business_id +
                ", create_time=" + create_time +
                '}';
    }
}
