package com.example.assc_android_task.ui.summary.repo

import com.example.assc_android_task.domain.dagger.modules.network.NetworkHandler
import com.example.assc_android_task.domain.network.Either
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.domain.network.RetrofitApi
import com.example.assc_android_task.domain.network.RetrofitService
import com.example.assc_android_task.domain.network.mMapToObject
import com.example.assc_android_task.domain.network.pullFromRequest
import com.example.assc_android_task.domain.network.validateType
import com.example.assc_android_task.ui.summary.model.SummaryRequestModel
import javax.inject.Inject
//MARK:- Summary Repo @Docs
interface SummaryRepository {
  fun getRecipeInfo(data: HashMap<String, Any>): Either<Failure, SummaryRequestModel>
  //MARK:- Network @Docs
  class NetWork @Inject constructor(
    val network: NetworkHandler,
    private val retrofitService: RetrofitService
  ) : SummaryRepository {
    override fun getRecipeInfo(data: HashMap<String, Any>): Either<Failure, SummaryRequestModel> {
      return pullFromRequest(
        network,
        call = retrofitService.getRecipeDetails(
          app_id = RetrofitApi.AppId, app_key = RetrofitApi.AppKey, recipe = data
        ), validate = { a -> a.validateType() }, transform = { a ->
        a.asJsonObject.mMapToObject()
      }, acceptunFormated = true
      )
    }
  }
}