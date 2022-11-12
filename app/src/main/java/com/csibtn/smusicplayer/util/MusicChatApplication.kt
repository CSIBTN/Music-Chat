package com.csibtn.smusicplayer.util

import android.app.Application
import android.os.Build
import com.google.android.material.color.DynamicColors

class MusicChatApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
            DynamicColors.applyToActivitiesIfAvailable(this)
    }
}