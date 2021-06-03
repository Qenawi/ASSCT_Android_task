package com.example.assc_android_task.ui.gredient.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AdapterItem(
  @SerializedName("calories")
  val cal: Double?,
  @SerializedName("totalWeight")
  val weight: Double?
) : Parcelable