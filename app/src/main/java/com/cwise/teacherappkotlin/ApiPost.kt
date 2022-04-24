package com.cwise.teacherappkotlin

import com.cwise.teacherappkotlin.models.ChildRecRes
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiPost {
    @POST("attendance_records")
    fun getPresentRec(@Body childRecRes: ChildRecRes): Call<ChildRecRes>
}