package com.example.assc_android_task.ui.summary.repo

import com.example.assc_android_task.domain.base.BaseUseCase
import com.example.assc_android_task.domain.network.Either
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.ui.summary.model.AdapterItem
import com.example.assc_android_task.ui.summary.model.SummaryRequestModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.ceil

//MARK:- Summary UseCase
class SummaryUseCase @Inject constructor(
  val scope: CoroutineScope,
  val dispatcher: CoroutineDispatcher,
  val repo: SummaryRepository
) : BaseUseCase(scope, dispatcher) {
  private val ingredKey = "ingr"

  //MARK- pull Recipe info
  fun getRecipeInfo(
    src: ArrayList<String>,
    call: (Either<Failure, SummaryRequestModel>) -> Unit = {}
  ) {
    scope.launch {
      val params = HashMap<String, Any>().apply {
        this[ingredKey] = src
      }
      val res = repo.getRecipeInfo(params)
      withContext(dispatcher) {
        call(res)
      }
    }
  }

  //MARK:- convert response object to Array of items
  fun convertToAdapterArray(data: SummaryRequestModel): ArrayList<AdapterItem> {
    val res = ArrayList<AdapterItem>()
    res.add(getCalories(data))
    res.add(getFat(data))
    res.add(getCholesterol(data))
    res.add(getSodium(data))
    res.add(getCarbohydrate(data))
    res.add(getProtein(data))
    res.add(getVitamin(data))
    res.add(getCalcium(data))
    res.add(getiron(data))
    res.add(getPotassium(data))
    return res
  }

  //MARK:- get each item content
  private fun getCalories(item: SummaryRequestModel): AdapterItem {
    val amount = item.calories.toString()
    val percent = ""
    val title = "Calories"
    val calItem = AdapterItem(amount = amount, percent = percent, title = title)
    return calItem
  }

  private fun getFat(item: SummaryRequestModel): AdapterItem {
    val amount =
      "${item.totalNutrients?.fAT?.quantity.safeRound()}${item.totalNutrients?.fAT?.unit}"
    val percent = "${item.totalDaily?.fAT?.quantity.safeRound()}${item.totalDaily?.fAT?.unit}"
    val title = "Fat"
    val fatItem = AdapterItem(amount = amount, percent = percent, title = title)
    return fatItem
  }

  private fun getCholesterol(item: SummaryRequestModel): AdapterItem {

    val amount =
      "${item.totalNutrients?.cHOLE?.quantity.safeRound()}${item.totalNutrients?.cHOLE?.unit}"
    val percent = "${item.totalDaily?.cHOLE?.quantity.safeRound()}${item.totalDaily?.cHOLE?.unit}"
    val title = "Cholesterol"
    val choleItem = AdapterItem(amount = amount, percent = percent, title = title)
    return choleItem
  }

  private fun getSodium(item: SummaryRequestModel): AdapterItem {

    val amount = "${item.totalNutrients?.nA?.quantity.safeRound()}${item.totalNutrients?.nA?.unit}"
    val percent = "${item.totalDaily?.nA?.quantity.safeRound()}${item.totalDaily?.nA?.unit}"
    val title = "Sodium"
    val sodiumItem = AdapterItem(amount = amount, percent = percent, title = title)
    return sodiumItem
  }

  private fun getCarbohydrate(item: SummaryRequestModel): AdapterItem {

    val amount =
      "${(item.totalNutrients?.sUGAR?.quantity.safeRound()) + (item.totalNutrients?.fIBTG?.quantity.safeRound())}${item.totalNutrients?.sUGAR?.unit}"
    val percent = "-"
    val title = "Carbohydrate (Sugar & Fiber) "
    val carpItem = AdapterItem(amount = amount, percent = percent, title = title)
    return carpItem
  }

  private fun getProtein(item: SummaryRequestModel): AdapterItem {

    val amount =
      "${(item.totalNutrients?.pROCNT?.quantity.safeRound())}${item.totalNutrients?.pROCNT?.unit}"
    val percent = "${item.totalDaily?.pROCNT?.quantity}${item.totalDaily?.pROCNT?.unit}"
    val title = "Protein"
    val proItem = AdapterItem(amount = amount, percent = percent, title = title)
    return proItem
  }

  private fun getVitamin(item: SummaryRequestModel): AdapterItem {

    val amount =
      "${
        (item.totalNutrients?.vITARAE?.quantity.safeRound()) +
          (item.totalNutrients?.vITC?.quantity.safeRound()) +
          (item.totalNutrients?.vITB6A?.quantity.safeRound()) +
          (item.totalNutrients?.vITB12?.quantity.safeRound()) +
          (item.totalNutrients?.vITD?.quantity.safeRound()) +
          (item.totalNutrients?.tOCPHA?.quantity.safeRound()) +
          (item.totalNutrients?.vITK1?.quantity.safeRound())
      }" + "µg"
    val percent = "${
      (item.totalDaily?.vITARAE?.quantity.safeRound()) +
        (item.totalDaily?.vITC?.quantity.safeRound()) +
        (item.totalDaily?.vITB6A?.quantity.safeRound()) +
        (item.totalDaily?.vITB12?.quantity.safeRound()) +
        (item.totalDaily?.vITD?.quantity.safeRound()) +
        (item.totalDaily?.tOCPHA?.quantity.safeRound()) +
        (item.totalDaily?.vITK1?.quantity.safeRound())
    }%"
    val title = "Vitamin"
    val vitItem = AdapterItem(amount = amount, percent = percent, title = title)
    return vitItem
  }

  private fun getCalcium(item: SummaryRequestModel): AdapterItem {
    val amount =
      "${(item.totalNutrients?.cA?.quantity.safeRound())}${item.totalNutrients?.cA?.unit}"
    val percent = "${item.totalDaily?.cA?.quantity.safeRound()}${item.totalDaily?.cA?.unit}"
    val title = "Calcium"
    val calItem = AdapterItem(amount = amount, percent = percent, title = title)
    return calItem
  }

  private fun getiron(item: SummaryRequestModel): AdapterItem {

    val amount =
      "${(item.totalNutrients?.fE?.quantity.safeRound())}${item.totalNutrients?.fE?.unit}"
    val percent = "${item.totalDaily?.fE?.quantity.safeRound()}${item.totalDaily?.fE?.unit}"
    val title = "iron"
    val ironItem = AdapterItem(amount = amount, percent = percent, title = title)
    return ironItem
  }

  private fun getPotassium(item: SummaryRequestModel): AdapterItem {

    val amount =
      "${(item.totalNutrients?.k?.quantity.safeRound())}${item.totalNutrients?.k?.unit}"
    val percent = "${item.totalDaily?.k?.quantity.safeRound()}${item.totalDaily?.k?.unit}"
    val title = "Potassium"
    val kItem = AdapterItem(amount = amount, percent = percent, title = title)
    return kItem
  }

  //MARK:- round value
  private fun Double?.safeRound(): Double {
    return this?.let { value ->
      "%.2f".format(value).toDouble()
    } ?: 0.0
  }
}