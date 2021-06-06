package com.example.assc_android_task.ui.ingredient.model

import android.os.Parcelable
import com.example.assc_android_task.domain.base.BaseParcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.Calendar

//MARK:- Ingredient-AdapterItem @Docs
@Parcelize
data class AdapterItem(
  @SerializedName("calories")
  var cal: Double?,
  @SerializedName("totalWeight")
  var weight: Double?,
  var title: String?,
  var unit: String?,
  var count: String?,

  ) : Parcelable, BaseParcelable {
  constructor() : this(cal = 0.0, weight = 0.0, title = "", unit = "", count = "")

  override fun unique(): Any {
    //MARK:- generate Unique content/id
    return Calendar.getInstance().timeInMillis.toString()
  }
}