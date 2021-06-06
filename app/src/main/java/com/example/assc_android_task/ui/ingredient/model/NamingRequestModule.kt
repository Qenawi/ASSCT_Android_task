package com.example.assc_android_task.ui.ingredient.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NamingRequestModule(
    @SerializedName("parsed")
    val parsed: List<Parsed?>?,
    @SerializedName("text")
    val text: String?
) : Parcelable {
    @Parcelize
    data class Parsed(
        @SerializedName("food")
        val food: Food?,
        @SerializedName("measure")
        val measure: Measure?,
        @SerializedName("quantity")
        val quantity: Double?
    ) : Parcelable {
        @Parcelize
        data class Food(
            @SerializedName("category")
            val category: String?,
            @SerializedName("categoryLabel")
            val categoryLabel: String?,
            @SerializedName("foodId")
            val foodId: String?,
            @SerializedName("image")
            val image: String?,
            @SerializedName("label")
            val label: String?,
            @SerializedName("nutrients")
            val nutrients: Nutrients?
        ) : Parcelable {
            @Parcelize
            data class Nutrients(
                @SerializedName("CHOCDF")
                val cHOCDF: Double?,
                @SerializedName("ENERC_KCAL")
                val eNERCKCAL: Double?,
                @SerializedName("FAT")
                val fAT: Double?,
                @SerializedName("FIBTG")
                val fIBTG: Double?,
                @SerializedName("PROCNT")
                val pROCNT: Double?
            ) : Parcelable
        }

        @Parcelize
        data class Measure(
            @SerializedName("label")
            val label: String?,
            @SerializedName("qualified")
            val qualified: List<Qualified?>?,
            @SerializedName("uri")
            val uri: String?
        ) : Parcelable {
            @Parcelize
            data class Qualified(
                @SerializedName("qualifiers")
                val qualifiers: List<Qualifier?>?
            ) : Parcelable {
                @Parcelize
                data class Qualifier(
                    @SerializedName("label")
                    val label: String?,
                    @SerializedName("uri")
                    val uri: String?
                ) : Parcelable
            }
        }
    }
}