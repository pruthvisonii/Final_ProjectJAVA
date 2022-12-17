package com.finalp.java.injection

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.finalp.java.ContactApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */


@Module
class AppModule(private val appCompatActivity: AppCompatActivity) {

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return appCompatActivity
    }

    @Provides
    @Singleton
    internal fun provideApp(): ContactApp {
        return appCompatActivity.application as ContactApp
    }

    @Provides
    @Singleton
    internal fun provideAppCompatActivity(): AppCompatActivity {
        return appCompatActivity
    }

    @Provides
    @Singleton
    internal fun getViewModelFactory(): ViewModelProvider.Factory {
        return ViewModelFactory(appCompatActivity)
    }
}
