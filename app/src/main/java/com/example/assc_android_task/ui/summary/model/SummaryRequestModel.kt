package com.example.assc_android_task.ui.summary.model


import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SummaryRequestModel(
    @SerializedName("calories")
    val calories: Int?,
    @SerializedName("cautions")
    val cautions: List<String?>?,
    @SerializedName("dietLabels")
    val dietLabels: List<String?>?,
    @SerializedName("healthLabels")
    val healthLabels: List<String?>?,
    @SerializedName("totalDaily")
    val totalDaily: TotalDaily?,
    @SerializedName("totalNutrients")
    val totalNutrients: TotalNutrients?,
    @SerializedName("totalNutrientsKCal")
    val totalNutrientsKCal: TotalNutrientsKCal?,
    @SerializedName("totalWeight")
    val totalWeight: Double?,
    @SerializedName("uri")
    val uri: String?,
    @SerializedName("yield")
    val yield: Double?
) : Parcelable {
    @Parcelize
    data class TotalDaily(
        @SerializedName("CA")
        val cA: CA?,
        @SerializedName("CHOCDF")
        val cHOCDF: CHOCDF?,
        @SerializedName("CHOLE")
        val cHOLE: CHOLE?,
        @SerializedName("ENERC_KCAL")
        val eNERCKCAL: ENERCKCAL?,
        @SerializedName("FASAT")
        val fASAT: FASAT?,
        @SerializedName("FAT")
        val fAT: FAT?,
        @SerializedName("FE")
        val fE: FE?,
        @SerializedName("FIBTG")
        val fIBTG: FIBTG?,
        @SerializedName("FOLDFE")
        val fOLDFE: FOLDFE?,
        @SerializedName("K")
        val k: K?,
        @SerializedName("MG")
        val mG: MG?,
        @SerializedName("NA")
        val nA: NA?,
        @SerializedName("NIA")
        val nIA: NIA?,
        @SerializedName("P")
        val p: P?,
        @SerializedName("PROCNT")
        val pROCNT: PROCNT?,
        @SerializedName("RIBF")
        val rIBF: RIBF?,
        @SerializedName("THIA")
        val tHIA: THIA?,
        @SerializedName("TOCPHA")
        val tOCPHA: TOCPHA?,
        @SerializedName("VITA_RAE")
        val vITARAE: VITARAE?,
        @SerializedName("VITB12")
        val vITB12: VITB12?,
        @SerializedName("VITB6A")
        val vITB6A: VITB6A?,
        @SerializedName("VITC")
        val vITC: VITC?,
        @SerializedName("VITD")
        val vITD: VITD?,
        @SerializedName("VITK1")
        val vITK1: VITK1?,
        @SerializedName("ZN")
        val zN: ZN?
    ) : Parcelable {
        @Parcelize
        data class CA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class CHOCDF(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class CHOLE(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class ENERCKCAL(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FASAT(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FAT(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FE(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FIBTG(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FOLDFE(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class K(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class MG(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class NA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class NIA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class P(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class PROCNT(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class RIBF(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class THIA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class TOCPHA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITARAE(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITB12(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITB6A(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITC(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITD(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITK1(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class ZN(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable
    }

    @Parcelize
    data class TotalNutrients(
        @SerializedName("CA")
        val cA: CA?,
        @SerializedName("CHOCDF")
        val cHOCDF: CHOCDF?,
        @SerializedName("CHOLE")
        val cHOLE: CHOLE?,
        @SerializedName("ENERC_KCAL")
        val eNERCKCAL: ENERCKCAL?,
        @SerializedName("FAMS")
        val fAMS: FAMS?,
        @SerializedName("FAPU")
        val fAPU: FAPU?,
        @SerializedName("FASAT")
        val fASAT: FASAT?,
        @SerializedName("FAT")
        val fAT: FAT?,
        @SerializedName("FATRN")
        val fATRN: FATRN?,
        @SerializedName("FE")
        val fE: FE?,
        @SerializedName("FIBTG")
        val fIBTG: FIBTG?,
        @SerializedName("FOLAC")
        val fOLAC: FOLAC?,
        @SerializedName("FOLDFE")
        val fOLDFE: FOLDFE?,
        @SerializedName("FOLFD")
        val fOLFD: FOLFD?,
        @SerializedName("K")
        val k: K?,
        @SerializedName("MG")
        val mG: MG?,
        @SerializedName("NA")
        val nA: NA?,
        @SerializedName("NIA")
        val nIA: NIA?,
        @SerializedName("P")
        val p: P?,
        @SerializedName("PROCNT")
        val pROCNT: PROCNT?,
        @SerializedName("RIBF")
        val rIBF: RIBF?,
        @SerializedName("SUGAR")
        val sUGAR: SUGAR?,
        @SerializedName("THIA")
        val tHIA: THIA?,
        @SerializedName("TOCPHA")
        val tOCPHA: TOCPHA?,
        @SerializedName("VITA_RAE")
        val vITARAE: VITARAE?,
        @SerializedName("VITB12")
        val vITB12: VITB12?,
        @SerializedName("VITB6A")
        val vITB6A: VITB6A?,
        @SerializedName("VITC")
        val vITC: VITC?,
        @SerializedName("VITD")
        val vITD: VITD?,
        @SerializedName("VITK1")
        val vITK1: VITK1?,
        @SerializedName("WATER")
        val wATER: WATER?,
        @SerializedName("ZN")
        val zN: ZN?
    ) : Parcelable {
        @Parcelize
        data class CA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class CHOCDF(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class CHOLE(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class ENERCKCAL(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FAMS(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FAPU(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FASAT(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FAT(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FATRN(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FE(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FIBTG(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FOLAC(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FOLDFE(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FOLFD(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class K(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class MG(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class NA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class NIA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class P(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class PROCNT(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class RIBF(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class SUGAR(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class THIA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class TOCPHA(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITARAE(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITB12(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITB6A(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITC(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITD(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class VITK1(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class WATER(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class ZN(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Double?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable
    }

    @Parcelize
    data class TotalNutrientsKCal(
        @SerializedName("CHOCDF_KCAL")
        val cHOCDFKCAL: CHOCDFKCAL?,
        @SerializedName("ENERC_KCAL")
        val eNERCKCAL: ENERCKCAL?,
        @SerializedName("FAT_KCAL")
        val fATKCAL: FATKCAL?,
        @SerializedName("PROCNT_KCAL")
        val pROCNTKCAL: PROCNTKCAL?
    ) : Parcelable {
        @Parcelize
        data class CHOCDFKCAL(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Int?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class ENERCKCAL(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Int?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class FATKCAL(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Int?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable

        @Parcelize
        data class PROCNTKCAL(
            @SerializedName("label")
            val label: String?,
            @SerializedName("quantity")
            val quantity: Int?,
            @SerializedName("unit")
            val unit: String?
        ) : Parcelable
    }
}