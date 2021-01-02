package com.artik.reddit

import android.app.Application
import com.artik.domain.di.DomainModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.androidModule

class App : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidModule(this@App))
        import(DomainModule.get())
    }

    override val kodeinTrigger = KodeinTrigger()

    override fun onCreate() {
        super.onCreate()
        kodeinTrigger.trigger()
    }
}