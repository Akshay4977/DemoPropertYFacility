package com.example.demopropertyfacilityjava.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyResponseModel {

    @SerializedName("facilities")
    @Expose
    private List<Facility> facilities;
    @SerializedName("exclusions")
    @Expose
    private List<List<Exclusion>> exclusions;

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public List<List<Exclusion>> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List<List<Exclusion>> exclusions) {
        this.exclusions = exclusions;
    }

}