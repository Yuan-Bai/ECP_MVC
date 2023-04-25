package com.rgxz.ecp.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Business {
    private Integer id;
    private Integer user_id;
    private String name;
    private String address;
    private String phone;
    private Integer credit=99;
    private String introduce;
    private String image_url="../webapps/ECP/image/business_head_image/default.jpg";
    private Timestamp create_time;

    public Business() {}

    public Business(String name) {
        this.name = name;
    }

    public Business(Integer user_id, String name, String address, String phone, String image_url) {
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.image_url = image_url;
    }

    public Business(Integer id, Integer user_id, String name, String address, String phone, Integer credit, String introduce, String image_url, Timestamp create_time) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.credit = credit;
        this.introduce = introduce;
        this.image_url = image_url;
        this.create_time = create_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", credit=" + credit +
                ", introduce='" + introduce + '\'' +
                ", image_url='" + image_url + '\'' +
                ", create_time=" + create_time +
                '}';
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(id));
        map.put("user_id", String.valueOf(user_id));
        map.put("name", name);
        map.put("address", address);
        map.put("phone", phone);
        map.put("credit", String.valueOf(credit));
        map.put("introduce", introduce);
        map.put("image_url", image_url);
        map.put("create_time", String.valueOf(create_time));
        return map;
    }
}
