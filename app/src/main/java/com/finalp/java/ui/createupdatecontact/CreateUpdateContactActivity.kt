package com.finalp.java.ui.createupdatecontact

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.finalp.java.R
import com.finalp.java.databinding.ActivityCreateupdateContactBinding
import com.finalp.java.injection.ViewModelFactory
import com.finalp.java.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_createupdate_contact.*
import javax.inject.Inject as Inject1

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */

open class CreateUpdateContactActivity : BaseActivity() {
    @Inject1
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var binding: ActivityCreateupdateContactBinding
    lateinit var viewModel: CreateUpdateContactViewModel

    var isUpdate = false
    var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getIntentData()
        binding = DataBindingUtil.setContentView(this,R.layout.activity_createupdate_contact)
        setSupportActionBar(toolbar)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CreateUpdateContactViewModel::class.java)
        binding.viewModel = viewModel
    }

    override fun onStart() {
        super.onStart()
        initData()
    }

    fun initData(){
        if (isUpdate) {
            supportActionBar!!.title = getString(R.string.editcontact)
            viewModel.preloadContactData(id)
        } else {
            supportActionBar!!.title = getString(R.string.addcontact)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getIntentData() {
        val extra = intent.extras
        if (extra != null) {
            isUpdate = extra.getBoolean("isUpdate",false)
            id = extra.getString("id")?:""
        }
    }
}
