package com.wb.bikeapp.helper

object Keys {

    init {
        System.loadLibrary("native-lib")
    }

    external fun apiKey(): String
}