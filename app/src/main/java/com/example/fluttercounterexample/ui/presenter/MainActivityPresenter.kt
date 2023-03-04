package com.example.fluttercounterexample.ui.presenter

import com.example.fluttercounterexample.ui.contract.MainActivityContract

class MainActivityPresenter : MainActivityContract.Presenter{
    private var view: MainActivityContract.View? = null

    private var count: Int = 0

    override fun attachView(view: MainActivityContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun onResume(view: MainActivityContract.View) {
        view.setCount(count)
    }

    override fun incrementCount() {
        count++
        view?.setCount(count)
    }

    override fun stop(){
        // none
    }
}