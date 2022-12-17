package com.finalp.java.restapi

import com.finalp.java.model.Contact
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */

interface ApiServices {
    @GET(ApiUrl.CONTACT)
    fun getContacts(): Observable<Response<ApiResponse<ArrayList<Contact>>>>

    @GET(ApiUrl.CONTACT_BY_ID)
    fun getContact(@Path("id") id:String): Observable<Response<ApiResponse<Contact>>>

    @POST(ApiUrl.CONTACT)
    fun postContact(@Body contact: Contact): Observable<Response<ApiResponse<Void>>>

    @PUT(ApiUrl.CONTACT_BY_ID)
    fun putContact(@Path("id") id:String, @Body contact: Contact): Observable<Response<ApiResponse<Contact>>>

    @DELETE(ApiUrl.CONTACT_BY_ID)
    fun deleteContact(@Path("id") id:String): Observable<Response<ApiResponse<Void>>>
}