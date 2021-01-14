package com.wb.bikeapp.remote.bike.response

import com.squareup.moshi.Json

data class Station(

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

data class TotalStands(

	@Json(name="availabilities")
	val availabilities: Availabilities? = null,

	@Json(name="capacity")
	val capacity: Int? = null
)

data class Position(

	@Json(name="latitude")
	val latitude: Double,

	@Json(name="longitude")
	val longitude: Double
)

data class Availabilities(

	@Json(name="stands")
	val stands: Int,

	@Json(name="bikes")
	val bikes: Int,

	@Json(name="electricalRemovableBatteryBikes")
	val electricalRemovableBatteryBikes: Int? = null,

	@Json(name="electricalBikes")
	val electricalBikes: Int,

	@Json(name="mechanicalBikes")
	val mechanicalBikes: Int? = null,

	@Json(name="electricalInternalBatteryBikes")
	val electricalInternalBatteryBikes: Int? = null
)

data class MainStands(

	@Json(name="availabilities")
	val availabilities: Availabilities,

	@Json(name="capacity")
	val capacity: Int
)
