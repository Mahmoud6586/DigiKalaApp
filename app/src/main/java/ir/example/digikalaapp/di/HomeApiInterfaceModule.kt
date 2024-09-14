package ir.example.digikalaapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.example.digikalaapp.data.datastore.DataStoreRepository
import ir.example.digikalaapp.data.datastore.DataStoreRepositoryImpl
import ir.example.digikalaapp.data.remote.HomeApiInterface
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//Applies over the whole app
object HomeApiInterfaceModule {

    @Provides
    @Singleton
    fun provideHomeApiService(retrofit: Retrofit): HomeApiInterface =
        retrofit.create(HomeApiInterface::class.java)
}