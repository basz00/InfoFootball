package com.baz.infofootball.network.di

import com.baz.infofootball.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val hostName = BuildConfig.BASE_URL_SSL
        val certificatePinner = CertificatePinner.Builder()
            .add(hostName, BuildConfig.SSL_PIN_1)
            .add(hostName, BuildConfig.SSL_PIN_2)
            .add(hostName, BuildConfig.SSL_PIN_3)
            .build()
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor {
                val requestBuilder = it.request().newBuilder()
                requestBuilder.addHeader(BuildConfig.API_HEADER, BuildConfig.KEY)
                it.proceed(requestBuilder.build())
            }
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}