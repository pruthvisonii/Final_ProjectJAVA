package com.finalp.java.ui

import androidx.lifecycle.ViewModel
import com.finalp.java.injection.AppModule
import com.finalp.java.injection.DaggerAppComponent
import com.finalp.java.restapi.ApiServices
import com.finalp.java.restapi.RestapiModule
import com.finalp.java.ui.createupdatecontact.CreateUpdateContactViewModel
import com.finalp.java.ui.detail.DetailViewModel
import com.finalp.java.ui.main.MainViewModel
import com.finalp.java.utils.BaseSchedulerProvider
import com.finalp.java.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */

abstract class BaseViewModel(var baseActivity: BaseActivity):ViewModel(){

    var schedulerProvider: BaseSchedulerProvider = SchedulerProvider()
    var appComponent =  DaggerAppComponent.builder().appModule(AppModule(baseActivity)).restapiModule(RestapiModule(baseActivity)).build()

    @Inject
    lateinit var apiServices: ApiServices

    var disposables = CompositeDisposable()

    init {
        inject()
    }

    override fun onCleared() {
        disposables.clear()
    }

    private fun inject() {
        when (this) {
            is MainViewModel -> appComponent.inject(this)
            is DetailViewModel -> appComponent.inject(this)
            is CreateUpdateContactViewModel -> appComponent.inject(this)
        }
    }

}
