package ru.atc_consulting.clientapp.domain;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.atc_consulting.clientapp.R;


public class User {

    private static User currentUser;

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

    private User(String login, String token) {
        this.login = login;
        this.token = token;

    }

    // Если пользователя нет в SharedPreferences или в статическом поле, то возвращаем Null.
    public static User getAuthorizedUser(Activity activity) {
        if (currentUser == null) {

            SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
            String login = sharedPref.getString(activity.getString(R.string.settings_login), null);
            String token = sharedPref.getString(activity.getString(R.string.settings_token), null);

            if (login != null && token != null) {
                currentUser = new User(login, token);
            }
        }

        return currentUser;
    }

    public static User loginUser(String login, String token, Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(activity.getString(R.string.settings_login), login);
        editor.putString(activity.getString(R.string.settings_token), token);
        editor.commit();
        currentUser = new User(login, token);
        return currentUser;
    }

    public void logout(Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        sharedPref.edit().remove(activity.getString(R.string.settings_login)).commit();
        sharedPref.edit().remove(activity.getString(R.string.settings_token)).commit();

    }
}
