package com.example.assc_android_task.ui.summary.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AdapterItem(
  val amount: String?,
  val percent: String?,
  val title: String?
) : Parcelable