package com.yusufcakmak.punkyapp.data.di

import com.yusufcakmak.punkyapp.BuildConfig
import com.yusufcakmak.punkyapp.data.IoDispatcher
import com.yusufcakmak.punkyapp.data.remote.RemoteCocktailDataSource
import com.yusufcakmak.punkyapp.data.remote.RemoteCocktailDataSourceImpl
import com.yusufcakmak.punkyapp.data.api.CoctailService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideBeerServiceInterface(retrofit: Retrofit): CoctailService {
        return retrofit.create()
    }


    @Provides
    @Singleton
    fun provideRemotePostsDataSource(
        api: CoctailService,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): RemoteCocktailDataSource {
        return RemoteCocktailDataSourceImpl(api, dispatcher)
    }

}
