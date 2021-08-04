package com.example.mixpaneldemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "my_cart_medicine")
public class MyCartMedicine implements Serializable {

    @PrimaryKey
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;


    @ColumnInfo(name = "quantity")
    private Integer quantity;

    @ColumnInfo(name = "unit")
    private String unit;

    @ColumnInfo(name = "price")
    private Double price;

    public MyCartMedicine(Integer id, String name, Integer quantity, String unit, Double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.price = price;
    }

    public MyCartMedicine() {

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MyCartMedicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }
}
