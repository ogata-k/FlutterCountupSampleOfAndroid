package com.example.fluttercounterexample.ui.presenter

import com.example.fluttercounterexample.ui.view.BaseView

interface BasePresenter<View : BaseView> {
    fun attachView(view: View)
    fun detachView()

    fun resume(view: View) {
        attachView(view)
        onResume(view)
    }

    /**
     * call from [resume]
     */
    fun onResume(view: View)

    fun pause() {
        detachView()
        onPause()
    }

    /**
     * call from [pause]
     */
    fun onPause()

    fun stop() {
        onStop()
    }

    /**
     * call from [stop]
     */
    fun onStop()
}