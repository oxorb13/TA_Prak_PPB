package com.example.ta_prakppb.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListMovieResponse {
    @SerializedName("status")
    private int status;

    @SerializedName("error")
    private String error;

    @SerializedName("response")
    private List<DataMovie> response;

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

    public List<DataMovie> getResponse() {
        return response;
    }

    public void setResponse(List<DataMovie> response) {
        this.response = response;
    }

    @Override
    public String toString(){
        return
                "ListMovieResponse{" +
                        "status = '" + status + '\'' +
                        ",error = '" + error + '\'' +
                        ",response = '" + response + '\'' +
                        "}";
    }
}
