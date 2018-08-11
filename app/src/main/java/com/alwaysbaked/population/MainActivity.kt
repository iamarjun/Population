package com.alwaysbaked.population

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.alwaysbaked.population.model.Root
import com.alwaysbaked.population.retrofit.APIService
import com.alwaysbaked.population.util.Adapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "Main2Activity"
    }

    private val apiServe by lazy {
        APIService.create()
    }

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: started.")

        //recycler view
        rvFeed.layoutManager = LinearLayoutManager(this)

        fetch()

    }

    private fun fetch() {
        Log.d(TAG, "fetch: started.")
        disposable = apiServe.theWorldPopulation
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { root ->
                    displayData(root)
                }

    }

    private fun displayData(root: Root) {
        val adapter = Adapter(this, root.worldpopulation)
        rvFeed.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }
}
