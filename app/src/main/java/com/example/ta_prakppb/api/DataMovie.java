package com.example.ta_prakppb.api;

import com.google.gson.annotations.SerializedName;

public class DataMovie {
    @SerializedName("film_id")
    private int film_id;

    @SerializedName("film_name")
    private String film_name;

    @SerializedName("film_type")
    private String film_type;

    @SerializedName("film_release")
    private String film_release;

    @SerializedName("film_timeline")
    private String film_timeline;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_type() {
        return film_type;
    }

    public void setFilm_type(String film_type) {
        this.film_type = film_type;
    }

    public String getFilm_release() {
        return film_release;
    }

    public void setFilm_release(String film_release) {
        this.film_release = film_release;
    }

    public String getFilm_timeline() {
        return film_timeline;
    }

    public void setFilm_timeline(String film_timeline) {
        this.film_timeline = film_timeline;
    }

    @Override
    public String toString(){
        return
                "DataMovie{" +
                        "film_id = '" + film_id + '\'' +
                        ",film_name = '" + film_name + '\'' +
                        ",film_type = '" + film_type + '\'' +
                        ",film_release = '" + film_release + '\'' +
                        ",film_timeline = '" + film_timeline + '\'' +
                        "}";
    }
}
