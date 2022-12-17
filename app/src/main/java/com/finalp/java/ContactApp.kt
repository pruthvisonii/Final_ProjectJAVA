package com.finalp.java

import android.app.Application
import android.content.Context



class ContactApp: Application() {
    lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}