package com.pavelwintercompany.skyengtrying.network

import com.pavelwintercompany.skyengtrying.models.DetailResponseModel
import com.pavelwintercompany.skyengtrying.models.QueryResponseModel
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Single

interface ApiInterface {

    @GET("words/search")
    fun getSearchList(@Query("search") search: String? = null): Single<List<QueryResponseModel>>

    @GET("meanings")
    fun getDetailMeaning(@Query("ids") ids: Int? = null): Single<List<DetailResponseModel>>

}