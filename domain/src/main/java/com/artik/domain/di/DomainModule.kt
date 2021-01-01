package com.artik.domain.di

import com.artik.domain.useCase.top.TopInteractor
import com.artik.domain.useCase.top.TopUseCase
import com.artik.remote.di.RemoteModule
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

object DomainModule {
    fun get() = Kodein.Module("Domain"){
        import(RemoteModule.get())

        bind<TopUseCase>() with provider { TopInteractor(instance()) }
    }
}