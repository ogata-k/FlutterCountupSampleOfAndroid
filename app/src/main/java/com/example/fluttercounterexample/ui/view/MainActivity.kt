package com.example.fluttercounterexample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.fluttercounterexample.databinding.ActivityMainBinding
import com.example.fluttercounterexample.ui.contract.MainActivityContract
import com.example.fluttercounterexample.ui.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainActivityPresenter()

        binding.countUpButton.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                presenter.incrementCount()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        presenter.resume(this)
    }

    override fun onPause() {
        presenter.pause()
        super.onPause()
    }

    override fun onStop() {
        presenter.stop()
        super.onStop()
    }

    override fun setCount(count: Int) {
        binding.countText.text = count.toString()
    }
}