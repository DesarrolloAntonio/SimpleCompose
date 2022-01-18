package com.desarrollodroide.simplecompose.api

import com.desarrollodroide.simplecompose.model.DummyObject
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
  @GET("posts")
  suspend fun getDataFromServer(): Response<List<DummyObject>>
}
