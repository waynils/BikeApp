package com.wb.bikeapp

class Constants {

    companion object {
        const val DEV_URL = "https://api.jcdecaux.com/"
        const val PROD_URL = "https://api.jcdecaux.com/"
        const val CONTRACT_KEY = "CONTRACT_KEY"
    }

    enum class HTTPStatus constructor(val code: Int) {
        BAD_REQUEST(400),
        FORBIDDEN(403),
        NOT_FOUND(404),
        INTERNAL_SERVER_ERROR(500);
    }

    enum class StationStatus constructor(val value: String) {
        OPEN("OPEN"),
        CLOSED("CLOSED");

        companion object {
            fun from(findValue: String): StationStatus = values().first { it.value == findValue }
        }
    }
}