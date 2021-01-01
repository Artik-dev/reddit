package com.artik.remote.di

import com.artik.remote.api.TopApi
import com.artik.remote.repository.ITopRepository
import com.artik.remote.repository.TopRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import retrofit2.Retrofit

object RemoteModule {
    fun get() = Kodein.Module("Rmote") {

        bind<TopApi>() with provider { instance<Retrofit>().create(TopApi::class.java) }
        bind<ITopRepository>() with provider { TopRepository(instance()) }
    }
}