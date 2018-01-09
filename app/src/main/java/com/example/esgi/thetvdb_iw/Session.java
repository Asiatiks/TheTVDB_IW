package com.example.esgi.thetvdb_iw;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Session implements Callback<List<Series>>{

    static final String BASE_URL = "https://api.thetvdb.com";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TheTVDBService theTVDBService = retrofit.create(TheTVDBService.class);
        //launch the request to TheTVDB api
        Call<List<Series>> call = theTVDBService.searchSeries("test");
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Series>> call, Response<List<Series>> response) {
        if (response.isSuccessful())
        {
            List<Series> seriesList = response.body();
            seriesList.forEach(series -> System.out.print(series.id));
        }
        else
        {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Series>> call, Throwable t) {
        t.printStackTrace();
    }
}
