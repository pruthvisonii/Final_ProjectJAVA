package com.finalp.java.injection

import com.finalp.java.restapi.RestapiModule
import com.finalp.java.ui.createupdatecontact.CreateUpdateContactActivity
import com.finalp.java.ui.createupdatecontact.CreateUpdateContactViewModel
import com.finalp.java.ui.detail.DetailActivity
import com.finalp.java.ui.detail.DetailViewModel
import com.finalp.java.ui.main.MainActivity
import com.finalp.java.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */

@Component(modules = [AppModule::class, RestapiModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(viewModel: MainViewModel)

    fun inject(activity: DetailActivity)
    fun inject(viewModel: DetailViewModel)

    fun inject(activity: CreateUpdateContactActivity)
    fun inject(viewModel: CreateUpdateContactViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun restapiModule(restapiModule: RestapiModule): Builder
        fun appModule(appModule: AppModule): Builder
    }

}
