package ir.example.digikalaapp.di

import androidx.room.PrimaryKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.example.digikalaapp.data.remote.ApiInterface
import ir.example.digikalaapp.util.Constants.BASE_URL
import ir.example.digikalaapp.util.Constants.TIMEOUT_IN_SECOND
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    internal fun interceptor(): HttpLoggingInterceptor {
        // It is used to log requests
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
        .addInterceptor(interceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)
}