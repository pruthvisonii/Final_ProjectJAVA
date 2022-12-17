package com.finalp.java.ui.detail

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.afollestad.materialdialogs.MaterialDialog
import com.finalp.java.model.Contact
import com.finalp.java.restapi.ApiResponse
import com.finalp.java.restapi.ErrorResponse
import com.finalp.java.restapi.RestApi
import com.finalp.java.restapi.RestSubscriber
import com.finalp.java.ui.BaseViewModel
import com.finalp.java.ui.createupdatecontact.CreateUpdateContactActivity
import com.finalp.java.ui.main.MainActivity
import okhttp3.Headers

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */
class DetailViewModel(var activity: DetailActivity):BaseViewModel(activity),
    RestSubscriber<ApiResponse<Contact>> {

    var loadingVisibility = MutableLiveData<Int>()

    val firstname = MutableLiveData<String>()
    val lastname = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val avatar = MutableLiveData<String>()
    var id = ""

    init {
        loadingVisibility.value = View.GONE
    }

    fun loadContactDetail(id:String){
        RestApi.call(
            disposables,
            apiServices.getContact(id),
            this,
            schedulerProvider
        )
    }

    override fun onRestCallStart() {
        loadingVisibility.value = View.VISIBLE
    }

    override fun onRestCallFinish() {
        loadingVisibility.value = View.GONE
    }

    override fun onSuccess(headers: Headers, body: ApiResponse<Contact>?) {
        loadingVisibility.value = View.GONE
        avatar.value = body!!.data!!.photo
        firstname.value = body.data!!.firstName
        lastname.value = body.data!!.lastName
        age.value = (body.data!!.age?:0).toString() + " yo"
        id = body.data!!.id?:""
    }

    override fun onFailed(error: ErrorResponse) {
        loadingVisibility.value = View.GONE
        MaterialDialog(activity).show {
            message(null, error.message)
            positiveButton {
                activity.finish()
            }
        }
    }

    val onUpdateClickListener = View.OnClickListener {
        val intent = Intent(activity,CreateUpdateContactActivity::class.java)
        intent.putExtra("id",id)
        intent.putExtra("isUpdate",true)
        activity.startActivityForResult(intent,MainActivity.IS_NEED_RELOAD)
    }

    val deleteContactRestSubscriber = object:RestSubscriber<ApiResponse<Void>>{
        override fun onRestCallStart() {
        }

        override fun onRestCallFinish() {
        }

        override fun onSuccess(headers: Headers, body: ApiResponse<Void>?) {
            MaterialDialog(activity).show {
                message(null,body!!.message)
                cancelable(false)
                cancelOnTouchOutside(false)
                positiveButton {
                    val resultIntent = Intent()
                    activity.setResult(Activity.RESULT_OK, resultIntent)
                    activity.finish()
                }
            }
        }

        override fun onFailed(error: ErrorResponse) {
            MaterialDialog(activity).show {
                message(null,error.message)
                cancelable(false)
                cancelOnTouchOutside(false)
                positiveButton { dismiss() }
            }
        }

    }

    fun deleteContact(){
        RestApi.call(
            disposables,
            apiServices.deleteContact(id),
            deleteContactRestSubscriber,
            schedulerProvider
        )
    }

    val onDeleteClickListener = View.OnClickListener {
        MaterialDialog(activity).show {
            message(null, "Are You sure you want to delete this contact?")
            cancelable(false)
            cancelOnTouchOutside(false)
            negativeButton(null,"CANCEL"){ dismiss() }
            positiveButton(null,"YES"){
                deleteContact()
            }
        }
    }
}
