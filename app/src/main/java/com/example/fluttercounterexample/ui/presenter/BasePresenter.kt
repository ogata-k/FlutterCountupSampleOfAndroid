package com.example.fluttercounterexample.ui.presenter

import com.example.fluttercounterexample.ui.view.BaseView

interface BasePresenter<View : BaseView> {
    fun attachView(view: View)
    fun detachView()

    fun resume(view: View) {
        attachView(view)
        onResume(view)
    }

    fun onResume(view: View)

    fun pause() {
        detachView()
    }

    fun stop()
}