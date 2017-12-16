package ru.atc_consulting.clientapp.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("login")
    @Expose
    private String login;

    /**
     * @return The login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login user login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token user token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
