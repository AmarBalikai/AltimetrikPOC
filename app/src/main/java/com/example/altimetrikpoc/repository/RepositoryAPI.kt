package com.example.altimetrikpoc.repository

import com.example.altimetrikpoc.network.ApiClient

class RepositoryAPI
{
    suspend fun getAllData()=ApiClient.build()?.getData()
}