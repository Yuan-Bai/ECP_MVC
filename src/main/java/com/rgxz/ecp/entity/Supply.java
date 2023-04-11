package com.rgxz.ecp.entity;

import java.sql.Timestamp;

public class Supply {
    private Integer id;
    private String goods_name;
    private Integer business_id;
    private Float price = 0.0f;
    private Integer amount = 0;
    private Timestamp crate_time;
    private String image_url = "src/main/webapp/image/goods_image/default.jpg";
    private String introduce;
    private String type;


    public Supply(){}

    public Supply(String goods_name, Integer business_id, Float price, Integer amount, String image_url, String introduce, String type) {
        this.goods_name = goods_name;
        this.business_id = business_id;
        this.price = price;
        this.amount = amount;
        this.image_url = image_url;
        this.introduce = introduce;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", business_id=" + business_id +
                ", price=" + price +
                ", amount=" + amount +
                ", crate_time=" + crate_time +
                ", image_url='" + image_url + '\'' +
                ", introduce='" + introduce + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Supply(Integer id, String goods_name, Integer business_id, Float price, Integer amount, Timestamp crate_time, String image_url, String introduce, String type) {
        this.id = id;
        this.goods_name = goods_name;
        this.business_id = business_id;
        this.price = price;
        this.amount = amount;
        this.crate_time = crate_time;
        this.image_url = image_url;
        this.introduce = introduce;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getCrate_time() {
        return crate_time;
    }

    public void setCrate_time(Timestamp crate_time) {
        this.crate_time = crate_time;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
