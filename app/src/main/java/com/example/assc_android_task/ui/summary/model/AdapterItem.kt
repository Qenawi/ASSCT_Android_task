package com.example.assc_android_task.ui.summary.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AdapterItem(
  val amount: Int?,
  val percent: Double?,
  val title: String?
) : Parcelable