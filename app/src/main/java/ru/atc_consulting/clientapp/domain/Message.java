package ru.atc_consulting.clientapp.domain;


public class Message {

    private String user;
    private String date;
    private String time;
    private String text;

    public Message(String user, String date, String time, String text) {
        this.user = user;
        this.date = date;
        this.time = time;
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
