package com.finalp.java.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.finalp.java.model.Contact
import com.finalp.java.restapi.ApiResponse
import com.finalp.java.restapi.ErrorResponse
import com.finalp.java.restapi.RestApi
import com.finalp.java.restapi.RestSubscriber
import com.finalp.java.ui.BaseViewModel
import okhttp3.Headers

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */
open class MainViewModel(var activity: MainActivity) : BaseViewModel(activity),
    RestSubscriber<ApiResponse<ArrayList<Contact>>> {

    val mainListAdapter = MainListAdapter(activity, ArrayList())
    val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    val isRefresh = MutableLiveData<Boolean>()
    val refreshListener = SwipeRefreshLayout.OnRefreshListener {
        loadAllContact()
    }

    fun loadAllContact() {
        RestApi.call(
            disposables,
            apiServices.getContacts(),
            this,
            schedulerProvider
        )
    }

    override fun onRestCallStart() {
        isRefresh.value = true
    }

    override fun onRestCallFinish() {
        isRefresh.value = false
    }

    override fun onSuccess(headers: Headers, body: ApiResponse<ArrayList<Contact>>?) {
        isRefresh.value = false
        mainListAdapter.updateData(body!!.data!!)
    }

    override fun onFailed(error: ErrorResponse) {
        isRefresh.value = false
    }
}
