package com.wb.bikeapp.remote.bike.response

import com.squareup.moshi.Json

data class ContractResponse(
    val listContract: List<Contract> = listOf()
)

data class Contract(

    @Json(name = "country_code")
    val countryCode: String? = null,

    @Json(name = "cities")
    val cities: List<String?>? = null,

    @Json(name = "name")
    val name: String,

    @Json(name = "commercial_name")
    val commercialName: String? = null
)
