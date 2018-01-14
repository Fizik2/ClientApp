package ru.atc_consulting.clientapp.domain;

/**
 * Created by fizik on 14.01.18.
 */

public class Special {
    private String date, text;

    public Special(String date, String text) {
        this.date = date;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }
}
