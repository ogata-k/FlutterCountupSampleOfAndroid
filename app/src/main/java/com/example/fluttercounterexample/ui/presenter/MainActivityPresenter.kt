package com.example.fluttercounterexample.ui.presenter

import com.example.fluttercounterexample.ui.contract.CounterViewContract

class MainActivityPresenter : CounterViewContract.Presenter {
    private var view: CounterViewContract.View? = null

    private var count: Int = 0

    override fun attachView(view: CounterViewContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun restoreStateOnCreate(count: Int) {
        this.count = count
    }

    override fun onResume(view: CounterViewContract.View) {
        view.setCount(count)
    }

    override fun onPause() {
        // none
    }

    override fun onStop() {
        // none
    }

    override fun getCountState(): Int {
        return count
    }

    override fun incrementCount() {
        count++
        view?.setCount(count)
    }
}