package com.finalp.java.restapi

import com.google.gson.annotations.SerializedName

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */
class ErrorResponse {
    @SerializedName("code")
    var code: Int = 0

    @SerializedName("message")
    var message: String? = null

    @SerializedName("description")
    var description: String? = null

    var httpStatus: HttpStatus? = null

    init {
        httpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE
        this.code = httpStatus!!.value()
        this.message = httpStatus!!.reasonPhrase
        this.description = httpStatus!!.reasonPhrase
    }

    override fun toString(): String {
        return "ErrorResponse {" +
                "status='" + code + '\''.toString() +
                ", message='" + message + '\''.toString() +
                ", description='" + description + '\''.toString() +
                '}'.toString()
    }
}
