package com.finalp.java.ui.main

import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.finalp.java.model.Contact
import com.finalp.java.ui.BaseViewModel
import com.finalp.java.ui.detail.DetailActivity
/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */
class MainListItemViewModel(var activity: MainActivity):BaseViewModel(activity){

    val name = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val avatar = MutableLiveData<String>()
    lateinit var contact: Contact

    fun bind(contact: Contact) {
        this.contact = contact
        name.value = contact.firstName + " " + contact.lastName
        age.value = contact.age.toString() + " yo"
        avatar.value = contact.photo
    }

    var onItemClickListener = View.OnClickListener {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("id", contact.id)
        activity.startActivityForResult(intent,MainActivity.IS_NEED_RELOAD)
    }

}
