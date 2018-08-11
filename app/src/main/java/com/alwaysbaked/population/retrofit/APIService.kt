package com.alwaysbaked.population.retrofit

import com.alwaysbaked.population.model.Root
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {

    @get:GET("tutorial/jsonparsetutorial.txt")
    val theWorldPopulation: Single<Root>

    companion object {
        fun create(): APIService {

            val retrofit = Retrofit.Builder()
                    .baseUrl("http://www.androidbegin.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit.create(APIService::class.java)

        }
    }
}

