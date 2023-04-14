package com.desarrollodroide.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DummyObjectDTO (
    @SerializedName("id")
    val id: Int?,

    @SerializedName("userId")
    val userId: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("body")
    val body: String?
    )