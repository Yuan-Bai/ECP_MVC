package com.rgxz.ecp.entity;

import java.sql.Date;

public class Goods {
    private String name;
    private String business;
    private String type;
    private String describe;
    private Date date;
    private String image_url;
    private int amount;
    private float price;

    public Goods(String name, String business, String type, String describe, Date date, String image_url, int amount, float price) {
        this.name = name;
        this.business = business;
        this.type = type;
        this.describe = describe;
        this.date = date;
        this.image_url = image_url;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", business='" + business + '\'' +
                ", type='" + type + '\'' +
                ", describe='" + describe + '\'' +
                ", date=" + date +
                ", image_url='" + image_url + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
