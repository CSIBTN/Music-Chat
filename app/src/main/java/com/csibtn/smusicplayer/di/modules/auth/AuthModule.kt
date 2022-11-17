package com.csibtn.smusicplayer.di.modules.auth

import com.csibtn.smusicplayer.ui.login.view.Authenticator
import com.csibtn.smusicplayer.ui.login.view.FirebaseAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object AuthModule {
    @Provides
    fun providesFirebase(): Authenticator = FirebaseAuthenticator()

}