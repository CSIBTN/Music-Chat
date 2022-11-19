package com.csibtn.smusicplayer.di.modules.auth

import com.csibtn.smusicplayer.ui.login.view.Authenticator
import com.csibtn.smusicplayer.ui.login.view.FirebaseAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun providesFirebase(): Authenticator = FirebaseAuthenticator()
}