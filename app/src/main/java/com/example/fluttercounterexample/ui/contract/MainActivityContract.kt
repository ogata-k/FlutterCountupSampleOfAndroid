package com.example.fluttercounterexample.ui.contract

import com.example.fluttercounterexample.ui.presenter.BasePresenter
import com.example.fluttercounterexample.ui.view.BaseView

interface MainActivityContract {
    interface View : BaseView {
        fun setCount(count: Int)
    }
    interface Presenter : BasePresenter<View> {
        fun incrementCount()
    }
}