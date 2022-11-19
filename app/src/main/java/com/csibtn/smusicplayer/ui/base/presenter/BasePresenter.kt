package com.csibtn.smusicplayer.ui.base.presenter

import android.view.View

interface BasePresenter {
    fun onAttachView(view: View)
    fun onDetachView()
}