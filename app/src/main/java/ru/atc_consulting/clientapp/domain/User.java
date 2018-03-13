package ru.atc_consulting.clientapp.domain;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.atc_consulting.clientapp.R;


public class User {

    private static User currentUser;

    private static final String[] defaultLogins = new String[]{
            "developersTest@atc-consulting.ru",
            "testApp@atc-consulting.ru",
            "testDev@atc-consulting.ru",
            "qwerty"};

    private static final String[] defaultPasswords = new String[]{"qwerty", "qwerty", "qwerty", "qwerty"};
    private static final Map<String, List<Cargo>> cargos = new HashMap<>();


    private static void fill1(){
        List<Cargo> list = new ArrayList<Cargo>();
        List<String> placesHistory = new ArrayList<>();
        placesHistory.add("20.01 - На станции назначении");
        placesHistory.add("08.01 - Движение по ЖД");
        placesHistory.add("01.01 - Ожидает ЖД");
        placesHistory.add("28.12 - Таможенное оформление");
        placesHistory.add("10.12 - В порту");
        placesHistory.add("01.12 - В море");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id786413", "Москва", "На станции назначении", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("10.02 - В порту");
        placesHistory.add("20.01 - В море");
        placesHistory.add("03.01 - У отправителя");
        list.add(new Cargo("id786414", "Хабаровск", "В порту", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("18.12 - У отправителя");
        list.add(new Cargo("id789415", "Владивосток", "У отправителя", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("20.12 - На станции назначении");
        placesHistory.add("08.12 - Движение по ЖД");
        placesHistory.add("01.12 - Ожидает ЖД");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id886412", "Москва", "Движение по ЖД", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("22.11 - Ожидает ЖД");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id896418", "Москва", "Ожидает ЖД", placesHistory));
        cargos.put(defaultLogins[0], list);
    }
    private static void fill2(){
        List<Cargo> list = new ArrayList<Cargo>();
        List<String> placesHistory = new ArrayList<>();
        placesHistory = new ArrayList<>();
        placesHistory.add("20.01 - На станции назначении");
        placesHistory.add("08.01 - Движение по ЖД");
        placesHistory.add("01.01 - Ожидает ЖД");
        placesHistory.add("28.12 - Таможенное оформление");
        placesHistory.add("10.12 - В порту");
        placesHistory.add("01.12 - В море");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id586413", "Москва", "На станции назначении", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("10.02 - В порту");
        placesHistory.add("20.01 - В море");
        placesHistory.add("03.01 - У отправителя");
        list.add(new Cargo("id736414", "Владивосток", "В порту", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("20.12 - На станции назначении");
        placesHistory.add("08.12 - Движение по ЖД");
        placesHistory.add("01.12 - Ожидает ЖД");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id886312", "Москва", "Движение по ЖД", placesHistory));
        cargos.put(defaultLogins[1], list);

    }
    private static void fill3(){
        List<Cargo> list = new ArrayList<Cargo>();
        List<String> placesHistory = new ArrayList<>();
        placesHistory.add("20.01 - На станции назначении");
        placesHistory.add("08.01 - Движение по ЖД");
        placesHistory.add("01.01 - Ожидает ЖД");
        placesHistory.add("28.12 - Таможенное оформление");
        placesHistory.add("10.12 - В порту");
        placesHistory.add("01.12 - В море");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id946613", "Москва", "На станции назначении", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("10.02 - В аэропорту");
        placesHistory.add("03.01 - У отправителя");
        list.add(new Cargo("id186414", "Владивосток", "В аэропорту", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("18.12 - У отправителя");
        list.add(new Cargo("id789415", "Москва", "У отправителя", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("20.12 - На станции назначении");
        placesHistory.add("08.12 - Движение по ЖД");
        placesHistory.add("01.12 - Ожидает ЖД");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id886412", "Хабаровск", "Движение по ЖД", placesHistory));

        cargos.put(defaultLogins[2], list);
    }
    private static void fill4(){
        List<Cargo> list = new ArrayList<Cargo>();
        List<String> placesHistory = new ArrayList<>();
        placesHistory.add("20.01 - На станции назначении");
        placesHistory.add("08.01 - Движение по ЖД");
        placesHistory.add("01.01 - Ожидает ЖД");
        placesHistory.add("28.12 - Таможенное оформление");
        placesHistory.add("10.12 - В порту");
        placesHistory.add("01.12 - В море");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id786413", "Москва", "На станции назначении", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("10.02 - В порту");
        placesHistory.add("20.01 - В море");
        placesHistory.add("03.01 - У отправителя");
        list.add(new Cargo("id786414", "Москва", "В порту", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("18.12 - У отправителя");
        list.add(new Cargo("id789415", "Хабаровск", "У отправителя", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("20.12 - На станции назначении");
        placesHistory.add("08.12 - Движение по ЖД");
        placesHistory.add("01.12 - Ожидает ЖД");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id886412", "Владивосток", "Движение по ЖД", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("22.11 - Ожидает ЖД");
        placesHistory.add("03.11 - У отправителя");
        list.add(new Cargo("id896416", "Москва", "Ожидает ЖД", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("12.11 - Ожидает ЖД");
        placesHistory.add("08.11 - У отправителя");
        list.add(new Cargo("id896417", "Владивосток", "Ожидает ЖД", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("25.12 - Ожидает ЖД");
        placesHistory.add("24.12 - У отправителя");
        list.add(new Cargo("id896418", "Москва", "Ожидает ЖД", placesHistory));

        placesHistory = new ArrayList<>();
        placesHistory.add("17.12 - Ожидает ЖД");
        placesHistory.add("10.12 - У отправителя");
        list.add(new Cargo("id896419", "Москва", "Ожидает ЖД", placesHistory));
        cargos.put(defaultLogins[3], list);
    }

    static {
        fill1();
        fill2();
        fill3();
        fill4();
    }

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

    public static List<Cargo> getCurrentCargos() {
        if (currentUser == null) return null;
        return cargos.get(currentUser.getLogin());
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

    public static boolean loginUser(String login, String password, Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(activity.getString(R.string.settings_login), login);
        editor.putString(activity.getString(R.string.settings_token), password);
        editor.commit();
        for (int i = 0; i < defaultLogins.length; i++) {
            if (defaultLogins[i].equals(login) && defaultPasswords[i].equals(password)) {
                currentUser = new User(login, password);
                return true;
            }
        }
        currentUser = new User(login, password);
        return false;
    }


    public static void logout(Activity activity) {
        currentUser = null;
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        sharedPref.edit().remove(activity.getString(R.string.settings_login)).commit();
        sharedPref.edit().remove(activity.getString(R.string.settings_token)).commit();

    }
}
