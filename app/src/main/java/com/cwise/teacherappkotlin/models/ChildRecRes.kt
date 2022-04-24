package com.cwise.teacherappkotlin.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.cwise.teacherappkotlin.models.Datum

class ChildRecRes(
    @field:SerializedName("id") private val id: String, @field:Expose @field:SerializedName(
        "status"
    ) private val status: String
) {
    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

}