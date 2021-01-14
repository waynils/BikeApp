package com.wb.bikeapp.remote.bike.response

import com.squareup.moshi.Json


//same data than #com.wb.bikeapp.api.bike.model.Station but seperate model for the test

data class StationDetailResponse(

	@Json(name="totalStands")
	val totalStands: TotalStands? = null,

	@Json(name="address")
	val address: String,

	@Json(name="shape")
	val shape: Any? = null,

	@Json(name="bonus")
	val bonus: Boolean,

	@Json(name="overflowStands")
	val overflowStands: Any? = null,

	@Json(name="banking")
	val banking: Boolean,

	@Json(name="connected")
	val connected: Boolean? = null,

	@Json(name="number")
	val number: Int,

	@Json(name="overflow")
	val overflow: Boolean? = null,

	@Json(name="lastUpdate")
	val lastUpdate: String? = null,

	@Json(name="name")
	val name: String,

	@Json(name="mainStands")
	val mainStands: MainStands,

	@Json(name="contractName")
	val contractName: String,

	@Json(name="position")
	val position: Position,

	@Json(name="status")
	val status: String
)

