package com.alwaysbaked.population.Retrofit;

import com.alwaysbaked.population.Model.Root;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface API {

    @GET("tutorial/jsonparsetutorial.txt")
    Observable<Root> getTheWorldPopulation();
}
