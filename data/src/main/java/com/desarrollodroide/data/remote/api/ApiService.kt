package com.desarrollodroide.data.remote.api

import com.desarrollodroide.data.remote.dto.DummyObjectDTO
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

  @GET("posts")
  suspend fun getDataFromServer(): Response<List<DummyObjectDTO>>

}
