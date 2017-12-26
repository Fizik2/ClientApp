package ru.atc_consulting.clientapp.domain;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cargo {

    private String id;
    private String status;
    private String lastPlace;
    private List<String> placesHistory;

    public Cargo(String id, String status, String lastPlace, List<String> placesHistory){
        this.id = id;
        this.status = status;
        this.lastPlace = lastPlace;
        this.placesHistory = placesHistory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastPlace() {
        return lastPlace;
    }

    public void setLastPlace(String lastPlace) {
        this.lastPlace = lastPlace;
    }

    public List<String> getPlacesHistory() {
        return placesHistory;
    }

    public void setPlacesHistory(List<String> placesHistory) {
        this.placesHistory = placesHistory;
    }
}
