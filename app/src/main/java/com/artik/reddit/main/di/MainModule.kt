package com.artik.reddit.main.di

import androidx.lifecycle.ViewModelProvider
import com.artik.reddit.main.ui.MainActivity
import com.artik.reddit.main.ui.MainRouter
import com.artik.reddit.main.ui.MainViewModel
import com.artik.reddit.main.ui.MainViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

object MainModule {
    fun get(activity: MainActivity) = Kodein.Module("Main") {

        bind() from singleton { MainRouter() }

        bind<MainViewModelFactory>() with provider {
            MainViewModelFactory(instance(), instance(), instance(), instance())
        }

        bind<MainViewModel>() with provider {
            instance<MainViewModelFactory>().let {
                ViewModelProvider(activity, it)[MainViewModel::class.java]
            }
        }
    }
}