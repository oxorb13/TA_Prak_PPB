package com.example.ta_prakppb.api;

import com.google.gson.annotations.SerializedName;

public class DataGundam {


    @SerializedName("product_id")
    private int product_id;

    @SerializedName("product_name")
    private String product_name;

    @SerializedName("product_price")
    private String product_price;

    @SerializedName("product_release")
    private String product_release;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_release() {
        return product_release;
    }

    public void setProduct_release(String product_release) {
        this.product_release = product_release;
    }

    @Override
    public String toString(){
        return
                "DataGundam{" +
                        "product_id = '" + product_id + '\'' +
                        ",product_name = '" + product_name + '\'' +
                        ",product_price = '" + product_price + '\'' +
                        ",product_release = '" + product_release + '\'' +
                        "}";
    }
}
