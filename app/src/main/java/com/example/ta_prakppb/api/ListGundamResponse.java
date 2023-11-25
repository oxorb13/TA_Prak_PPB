package com.example.ta_prakppb.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListGundamResponse {
//    TODO Contoh
//    @SerializedName("per_page")
//    private int perPage;

    @SerializedName("status")
    private int status;

    @SerializedName("error")
    private String error;

    @SerializedName("response")
    private List<DataGundam> response;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<DataGundam> getResponse() {
        return response;
    }

    public void setResponse(List<DataGundam> response) {
        this.response = response;
    }

    @Override
    public String toString(){
        return
                "ListGundamResponse{" +
                        "status = '" + status + '\'' +
                        ",error = '" + error + '\'' +
                        ",response = '" + response + '\'' +
                        "}";
    }
}
