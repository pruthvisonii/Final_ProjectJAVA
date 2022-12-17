package com.finalp.java.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.finalp.java.injection.AppComponent
import com.finalp.java.injection.AppModule
import com.finalp.java.injection.DaggerAppComponent
import com.finalp.java.restapi.RestapiModule
import com.finalp.java.ui.createupdatecontact.CreateUpdateContactActivity
import com.finalp.java.ui.detail.DetailActivity
import com.finalp.java.ui.main.MainActivity

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */

open class BaseActivity : AppCompatActivity() {
    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent =  DaggerAppComponent.builder().appModule(AppModule(this)).restapiModule(RestapiModule(this)).build()
        inject()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        appComponent =  DaggerAppComponent.builder().appModule(AppModule(this)).restapiModule(RestapiModule(this)).build()
        inject()
    }

    private fun inject() {
        when (this) {
            is MainActivity -> appComponent.inject(this)
            is DetailActivity -> appComponent.inject(this)
            is CreateUpdateContactActivity -> appComponent.inject(this)
        }
    }
}
