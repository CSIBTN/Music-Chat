package com.csibtn.smusicplayer.util


interface Contract {

    interface View {

        fun showProgress()

        fun hideProgress()
    }

    interface Model {


    }

    interface Presenter {

        fun onButtonClick()

        fun onDestroy()
    }

}