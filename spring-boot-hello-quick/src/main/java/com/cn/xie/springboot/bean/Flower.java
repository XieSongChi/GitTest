package com.cn.xie.springboot.bean;

import java.util.Date;

/**
 * @program: spring-boot-hello-quick
 * @description:
 * @author: Mr.Xie
 * @create: 2019-04-09 11:12
 */
public class Flower {
    private Integer id;
    private String name;
    private float price;
    private String production;
    private Date updatetime;
    private String images;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
