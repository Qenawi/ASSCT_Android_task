package com.example.assc_android_task.ui.summary.model

import android.os.Parcelable
import com.example.assc_android_task.domain.base.BaseParcelable
import kotlinx.android.parcel.Parcelize
import java.util.Calendar

//MARK:- Summary-AdapterItem @Docs
@Parcelize
data class AdapterItem(
  val amount: String?,
  val percent: String?,
  val title: String?
) : Parcelable, BaseParcelable {
  override fun unique(): Any {
    //MARK:- generate Unique content/id
    return Calendar.getInstance().timeInMillis.toString()
  }
}