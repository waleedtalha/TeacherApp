package com.cwise.teacherappkotlin.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Datum {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("user_type")
    @Expose
    var userType: String? = null

    @SerializedName("email_verified_at")
    @Expose
    var emailVerifiedAt: Any? = null

    @SerializedName("fcm_token")
    @Expose
    var fcmToken: String? = null

    @SerializedName("auth_token")
    @Expose
    var authToken: String? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null

    @SerializedName("childs_name")
    @Expose
    var childsName: String? = null

    @SerializedName("childs_age")
    @Expose
    var childsAge: String? = null

    @SerializedName("childs_gender")
    @Expose
    var childsGender: String? = null

    @SerializedName("childs_grade")
    @Expose
    var childsGrade: String? = null

    @SerializedName("Schools_name")
    @Expose
    var schoolsName: String? = null

    @SerializedName("phone_no")
    @Expose
    var phoneNo: String? = null

    @SerializedName("pickup_lat")
    @Expose
    var pickupLat: String? = null

    @SerializedName("pickup_lng")
    @Expose
    var pickupLng: String? = null

    @SerializedName("dropoff_lat")
    @Expose
    var dropoffLat: String? = null

    @SerializedName("dropoff_lng")
    @Expose
    var dropoffLng: String? = null

    @SerializedName("payment_status")
    @Expose
    var paymentStatus: Int? = null

    @SerializedName("block_status")
    @Expose
    var blockStatus: Int? = null

    @SerializedName("qr_code")
    @Expose
    var qrCode: String? = null

    @SerializedName("childs_image")
    @Expose
    var childsImage: String? = null

    @SerializedName("driver_lat")
    @Expose
    var driverLat: Double? = null

    @SerializedName("driver_long")
    @Expose
    var driverLong: Double? = null

    @SerializedName("childs_attendance")
    @Expose
    var childsAttendance: String? = null
}