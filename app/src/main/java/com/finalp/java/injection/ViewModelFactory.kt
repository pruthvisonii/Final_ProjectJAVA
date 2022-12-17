package com.finalp.java.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.finalp.java.ui.createupdatecontact.CreateUpdateContactActivity
import com.finalp.java.ui.createupdatecontact.CreateUpdateContactViewModel
import com.finalp.java.ui.detail.DetailActivity
import com.finalp.java.ui.detail.DetailViewModel
import com.finalp.java.ui.main.MainActivity
import com.finalp.java.ui.main.MainViewModel
import javax.inject.Inject

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */

class ViewModelFactory @Inject constructor(var appCompatActivity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> @Suppress("UNCHECKED_CAST")
            return MainViewModel(appCompatActivity as MainActivity) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> @Suppress("UNCHECKED_CAST")
            return DetailViewModel(appCompatActivity as DetailActivity) as T
            modelClass.isAssignableFrom(CreateUpdateContactViewModel::class.java) -> @Suppress("UNCHECKED_CAST")
            return CreateUpdateContactViewModel(appCompatActivity as CreateUpdateContactActivity) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
