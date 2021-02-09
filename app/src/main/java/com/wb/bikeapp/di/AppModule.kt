package com.wb.bikeapp.di

import com.squareup.moshi.Moshi
import com.wb.bikeapp.BikeApp
import com.wb.bikeapp.helper.Keys
import com.wb.bikeapp.helper.variant.VariantHelper
import com.wb.bikeapp.helper.variant.VariantHelperImpl
import com.wb.bikeapp.remote.bike.BikeApiService
import com.wb.bikeapp.remote.bike.BikeApiServiceImpl
import com.wb.bikeapp.repositories.BikeRepository
import com.wb.bikeapp.repositories.BikeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideVariantHelper(helper: VariantHelperImpl): VariantHelper = helper

    //REPO
    @Singleton
    @Provides
    fun provideBikeRepository(repository: BikeRepositoryImpl): BikeRepository = repository

    //API
    @Singleton
    @Provides
    fun provideBikeApiService(api: BikeApiServiceImpl): BikeApiService = api

    /*
    *
    *
    * RETROFIT
    *
    *
    *
     */
    @Singleton
    @Provides
    fun provideRetrofit(variantHelper: VariantHelper): Retrofit {
        val moshi = Moshi.Builder()
            .build()

        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(provideOkHttpClient())
            .baseUrl(variantHelper.getBackendEndPoint())
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS)

        okhttpClientBuilder.addInterceptor { chain ->
            val request = chain.request().newBuilder()
            val originalHttpUrl = chain.request().url()
            val urlWithApiKey =
                originalHttpUrl.newBuilder().addQueryParameter("apiKey", Keys.apiKey()).build()
            request.url(urlWithApiKey)
            val response = chain.proceed(request.build())
            response
        }
        return okhttpClientBuilder.build()
    }
}