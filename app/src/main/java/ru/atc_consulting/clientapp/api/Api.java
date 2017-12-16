package ru.atc_consulting.clientapp.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.atc_consulting.clientapp.domain.User;

public interface Api {
    @GET("/login/")
    Call<User> login(@Query("login") String login, @Query("pass") String hash);
}
