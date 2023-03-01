package com.abbreviationdemo.dependencies

import com.abbreviationdemo.AbbreviationAPIs
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://www.nactem.ac.uk/software/acromine/"

@Module
class HttpModule {

    @Provides
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    fun getAbbreviationAPI(retrofit: Retrofit) = retrofit.create(AbbreviationAPIs::class.java)
}
