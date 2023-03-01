package com.abbreviationdemo

import com.abbreviationdemo.models.FullForms
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AbbreviationAPIs {
    @GET("dictionary.py")
    fun getFullForms(@Query("sf") sf: String): Single<List<FullForms>>
}
