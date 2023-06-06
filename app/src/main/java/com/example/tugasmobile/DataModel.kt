package com.example.tugasmobile

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataModel(
    @Json(name = "id") val id: Int,
    @Json(name = "type") val type: String,
    @Json(name = "setup") val setup: String,
    @Json(name = "punchline") val punchline: String
)
