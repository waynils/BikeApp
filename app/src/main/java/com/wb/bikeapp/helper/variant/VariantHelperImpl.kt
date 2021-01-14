package com.wb.bikeapp.helper.variant

import com.wb.bikeapp.BuildConfig
import com.wb.bikeapp.Constants
import javax.inject.Inject
import javax.inject.Singleton

enum class EnvironmentType {
    DEV,
    PROD
}

@Singleton
class VariantHelperImpl @Inject constructor() : VariantHelper {

    private val environment = getEnvironmentType()

    override fun getBackendEndPoint(): String {
        return when (environment) {
            EnvironmentType.DEV -> Constants.DEV_URL
            EnvironmentType.PROD -> Constants.PROD_URL
        }
    }

    private fun getEnvironmentType(): EnvironmentType {

        if (getBuildType() == "debug") {
            return EnvironmentType.DEV
        }
        if (getBuildType() == "release") {
            return EnvironmentType.PROD
        }

        throw Exception("no EnvironmentType find for ${getBuildType()}")
    }

    private fun getBuildType(): String {
        return BuildConfig.BUILD_TYPE
    }
}