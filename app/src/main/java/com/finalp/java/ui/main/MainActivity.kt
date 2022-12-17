package com.finalp.java.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.finalp.java.R
import com.finalp.java.databinding.ActivityMainBinding
import com.finalp.java.injection.ViewModelFactory
import com.finalp.java.ui.BaseActivity
import com.finalp.java.ui.createupdatecontact.CreateUpdateContactActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */

open class MainActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity,CreateUpdateContactActivity::class.java)
            startActivityForResult(intent, IS_NEED_RELOAD)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadAllContact()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1001){
            if(resultCode== Activity.RESULT_OK){
                viewModel.loadAllContact()
            }
        }
    }

    companion object {
        val IS_NEED_RELOAD = 1001
    }
}
