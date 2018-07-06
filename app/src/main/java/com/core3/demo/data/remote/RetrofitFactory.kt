package com.core3.demo.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getClientBuilder() = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val withHeaders = original.newBuilder()
                        .header("Content-Type", "application/json")
                        .method(original.method(), original.body())
                        .build()

                chain.proceed(withHeaders)
            }
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    fun <T> createWithoutAuthorization(clazz: Class<T>) = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getClientBuilder().build())
            .build()
            .create(clazz)!!
}
