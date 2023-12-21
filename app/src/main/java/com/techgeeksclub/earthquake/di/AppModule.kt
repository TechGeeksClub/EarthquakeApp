package com.techgeeksclub.earthquake.di

import android.content.Context
import com.techgeeksclub.earthquake.data.datasource.EarthquakeDataSource
import com.techgeeksclub.earthquake.data.repository.EarthquakeRepository
import com.techgeeksclub.earthquake.retrofit.ApiUtils
import com.techgeeksclub.earthquake.retrofit.EarthquakeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideEarthquakeDao() : EarthquakeDao {
        return ApiUtils.getEarthquakeDao()
    }

    @Provides
    @Singleton
    fun provideEarthquakeDataSource(context: Context, earthquakeDao: EarthquakeDao) : EarthquakeDataSource{
        return EarthquakeDataSource(provideContext(context),earthquakeDao)
    }

    @Provides
    @Singleton
    fun provideEarthquakeRepository(earthquakeDataSource: EarthquakeDataSource) : EarthquakeRepository {
        return EarthquakeRepository(earthquakeDataSource)
    }

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
}