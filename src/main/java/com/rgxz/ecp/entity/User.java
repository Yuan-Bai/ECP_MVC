package com.rgxz.ecp.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer id;
    private String name;
    private String pwd;
    private Boolean is_business;
    private String address;
    private String phone;
    private Float balance = 0F;
    private String gender = "保密";
    private String image_url = "src/main/webapp/image/user_head_image/default.jpg";
    private Integer identity = 0;
    private String ip;
    private Timestamp create_time = null;
    private Business business = null;

    public User(){}

    public User(String name, String pwd, String ip) {
        this.name = name;
        this.pwd = pwd;
        this.ip = ip;
    }

    public User(Integer id, String name, String pwd, String address, String phone, Float balance, String gender, String image_url, Integer identity, String ip, Timestamp create_time) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
        this.gender = gender;
        this.image_url = image_url;
        this.identity = identity;
        this.ip = ip;
        this.create_time = create_time;
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

    public Boolean getIs_business() {
        return is_business;
    }

    public void setIs_business(Boolean is_business) {
        this.is_business = is_business;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", is_business=" + is_business +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", gender='" + gender + '\'' +
                ", image_url='" + image_url + '\'' +
                ", identity=" + identity +
                ", ip='" + ip + '\'' +
                ", create_time=" + create_time +
                ", business=" + business +
                '}';
    }
}
