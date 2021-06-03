package com.example.assc_android_task.ui.gredient.repo

import com.example.assc_android_task.domain.dagger.modules.network.NetworkHandler
import com.example.assc_android_task.domain.network.Either
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.domain.network.RetrofitApi
import com.example.assc_android_task.domain.network.RetrofitService
import com.example.assc_android_task.domain.network.mMapToObject
import com.example.assc_android_task.domain.network.pullFromRequest
import com.example.assc_android_task.domain.network.validateType
import com.example.assc_android_task.ui.gredient.model.AdapterItem
import javax.inject.Inject

interface GradientRepo {
  fun getitemInfo(string: String): Either<Failure, AdapterItem>

  class NetWork @Inject constructor(
    val retrofit: RetrofitService,
    val network: NetworkHandler
  ) : GradientRepo {
    override fun getitemInfo(string: String): Either<Failure, AdapterItem> {
      return pullFromRequest(
        network,
        call = retrofit.single_food_item(
          app_id = RetrofitApi.AppId, app_key = RetrofitApi.AppKey, ingred = string
        ), validate = { a -> a.validateType() },
        transform = { a -> a.asJsonObject.mMapToObject<AdapterItem>() }, acceptunFormated = true
      )
    }
  }
}