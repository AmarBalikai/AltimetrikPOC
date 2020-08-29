package com.example.altimetrikpoc.network

import com.example.altimetrikpoc.model.ModelData
import com.example.altimetrikpoc.utils.Constant.Companion.GET_DATA
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET(GET_DATA)
    suspend fun getData(): Response<ModelData>

}