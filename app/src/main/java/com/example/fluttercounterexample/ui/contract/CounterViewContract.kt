package com.example.fluttercounterexample.ui.contract

import com.example.fluttercounterexample.ui.presenter.BasePresenter
import com.example.fluttercounterexample.ui.view.BaseView

interface CounterViewContract {
    interface View : BaseView {
        fun setCount(count: Int)
    }

    interface Presenter : BasePresenter<View> {
        fun restoreStateOnCreate(count: Int)

        // 保存するべき状態であることがわかりやすいようにStateをサフィックスとしてつける
        fun getCountState(): Int
        fun incrementCount()
    }
}