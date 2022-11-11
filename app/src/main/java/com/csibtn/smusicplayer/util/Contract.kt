package com.csibtn.smusicplayer.util


interface Contract {

    interface View {

        fun showProgress()

        fun hideProgress()
    }

    interface Model {
        interface OnFinishedListener {

            fun onFinished(string: String?)
        }

    }

    interface Presenter {

        fun onButtonClick()

        fun onDestroy()
    }

}