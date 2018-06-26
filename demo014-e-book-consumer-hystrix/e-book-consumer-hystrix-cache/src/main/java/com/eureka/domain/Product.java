package com.eureka.domain;

import java.io.Serializable;

/**
 * what:
 *
 * @author 孙超 created on 2018/4/7
 */
public class Product implements Serializable{
    private int id;
    private String name;

    public Product() {
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
