package com.example.esgi.thetvdb_iw;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TheTVDBService {

    public static final String ENDPOINT = "https://api.thetvdb.com";

    //Join login link
    @POST("/login")
//    Call<Token>

    @GET("/search/series")
    Call<List<Series>> searchSeries(@Query("name") String name);
}
