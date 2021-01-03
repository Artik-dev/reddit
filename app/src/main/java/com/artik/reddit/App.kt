package com.artik.reddit

import android.app.Application
import com.artik.core.PermissionManager
import com.artik.domain.di.DomainModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.androidModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidModule(this@App))
        import(DomainModule.get())

        bind() from singleton { PermissionManager(instance()) }
    }

    override val kodeinTrigger = KodeinTrigger()

    override fun onCreate() {
        super.onCreate()
        kodeinTrigger.trigger()
    }
}