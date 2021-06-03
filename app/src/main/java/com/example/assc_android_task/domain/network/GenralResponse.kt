package com.example.assc_android_task.domain.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

//todo status code int
@Parcelize
data class GeneralResponseObject
(
  @SerializedName("validationMessage")
  val message_three:String?=null,
  @SerializedName("validateMessage")
  val message_one: String?=null,
  @SerializedName("message")
  val message_two: String?=null,
  @SerializedName("status")
  val status: Int?=null,
  @SerializedName("statusCode")
  val statusCode:Int?=null,
  @SerializedName("object")
  val data: @RawValue Any?=null
) : Parcelable

