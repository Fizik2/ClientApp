package ru.atc_consulting.clientapp;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.atc_consulting.clientapp.api.Api;


public class App extends Application {
    private static Api api;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url)) //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        api = retrofit.create(Api.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static Api getApi() {
        return api;
    }
}
