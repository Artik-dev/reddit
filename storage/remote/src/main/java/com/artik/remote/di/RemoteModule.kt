package com.artik.remote.di

import com.artik.remote.api.TopApi
import com.artik.remote.repository.ITopRepository
import com.artik.remote.repository.TopRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RemoteModule {
    fun get() = Kodein.Module("Remote") {

        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                .baseUrl("https://www.reddit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(instance())
                .build()
        }

        bind<OkHttpClient>() with singleton {
            val builder = OkHttpClient.Builder()

            builder.retryOnConnectionFailure(true)

            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }.let {
                builder.addInterceptor(it)
            }

            builder.build()
        }

        bind<TopApi>() with singleton { instance<Retrofit>().create(TopApi::class.java) }
        bind<ITopRepository>() with provider { TopRepository(instance()) }
    }
}