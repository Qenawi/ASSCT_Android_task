package com.example.assc_android_task.domain.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

//MARK:- Base GeneralResponseObject
@Parcelize
data class GeneralResponseObject
(
  @SerializedName("status")
  val status: String? = null,
  @SerializedName("error")
  val message: String? = null,
  @SerializedName("object")
  val data: @RawValue Any? = null
) : Parcelable

