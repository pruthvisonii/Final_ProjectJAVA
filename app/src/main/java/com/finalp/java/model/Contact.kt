package com.finalp.java.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */


class Contact {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("firstName")
    @Expose
    var firstName: String? = null
    @SerializedName("lastName")
    @Expose
    var lastName: String? = null
    @SerializedName("age")
    @Expose
    var age: Int? = null
    @SerializedName("photo")
    @Expose
    var photo: String? = null
}
