package fr.poseidonj.marketapp.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product extends BaseEntity {

    private String desc;
    private double price;

    public Product(int id, String desc, double price) {
        super(id);
        this.desc = desc;
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return  desc;
    }
}
