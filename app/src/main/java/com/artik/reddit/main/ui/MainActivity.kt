package com.artik.reddit.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.artik.reddit.R
import com.artik.reddit.main.adapter.MainRecyclerAdapter
import com.artik.reddit.main.di.MainModule
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    private val _parentKodein by closestKodein()

    override val kodein: Kodein by retainedKodein {
        extend(_parentKodein)
        import(MainModule.get(this@MainActivity), allowOverride = true)
    }

    override val kodeinTrigger = KodeinTrigger()

    private val viewModel: MainViewModel by instance()
    private val router: IMainRouter by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kodeinTrigger.trigger()

        (router as MainRouter).attachActivity(this)

        val adapter = MainRecyclerAdapter(viewModel)
        mainRecycler.adapter = adapter

        viewModel.mainRecyclerDataSource.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    override fun onDestroy() {
        (router as MainRouter).detachActivity()
        super.onDestroy()
    }
}