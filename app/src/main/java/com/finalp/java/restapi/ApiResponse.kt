package com.finalp.java.restapi

import com.google.gson.annotations.SerializedName

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */
class ApiResponse<T> {
    @SerializedName("message")
    var message: String? = null

    @SerializedName("data")
    var data: T? = null
}