package com.example.ta_prakppb;

public class DataModel {
    int gambar;
    private String title;

    public DataModel(int gambar) {
        this.gambar = gambar;
        this.title = title;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
