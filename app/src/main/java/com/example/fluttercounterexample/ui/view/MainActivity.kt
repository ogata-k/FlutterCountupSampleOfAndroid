package com.example.fluttercounterexample.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.fluttercounterexample.databinding.ActivityMainBinding
import com.example.fluttercounterexample.ui.contract.MainActivityContract
import com.example.fluttercounterexample.ui.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityContract.View {
    companion object {
        const val VIEW_NAME = "MainActivity"
        const val COUNT_BUNDLE_KEY = "COUNT_TEXT_VALUE"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(VIEW_NAME, "onCreate")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainActivityPresenter()

        // Activityを破棄した時の状態を可能な限り復元する
        if (savedInstanceState != null) {
            Log.d(VIEW_NAME, "onRestoreInstanceStateOfOnCreate")
            val countState: Int = savedInstanceState.getInt(COUNT_BUNDLE_KEY, 0)
            presenter.restoreStateOnCreate(countState)
        }

        binding.countUpButton.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                presenter.incrementCount()
            }
        })
    }

    override fun onResume() {
        Log.d(VIEW_NAME, "onResume")
        super.onResume()
        presenter.resume(this)
    }

    override fun onPause() {
        Log.d(VIEW_NAME, "onPause")
        presenter.pause()
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(VIEW_NAME, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_BUNDLE_KEY, presenter.getCountState())
    }

    override fun onStop() {
        Log.d(VIEW_NAME, "onStop")
        presenter.stop()
        super.onStop()
    }

    override fun setCount(count: Int) {
        binding.countText.text = count.toString()
    }
}