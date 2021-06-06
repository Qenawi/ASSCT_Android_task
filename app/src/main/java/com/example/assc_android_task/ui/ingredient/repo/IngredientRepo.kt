package com.example.assc_android_task.ui.ingredient.repo

import com.example.assc_android_task.domain.dagger.modules.network.NetworkHandler
import com.example.assc_android_task.domain.network.Either
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.domain.network.RetrofitApi
import com.example.assc_android_task.domain.network.RetrofitService
import com.example.assc_android_task.domain.network.mMapToObject
import com.example.assc_android_task.domain.network.pullFromRequest
import com.example.assc_android_task.domain.network.validateType
import com.example.assc_android_task.ui.ingredient.model.AdapterItem
import com.example.assc_android_task.ui.ingredient.model.NamingRequestModule
import javax.inject.Inject

//MARK:- Ingredient Repository @Docs
interface IngredientRepo {
  fun getItemInfo(string: String): Either<Failure, AdapterItem>
  fun getItemInfoNaming(string: String): Either<Failure, NamingRequestModule>

  //MARK:- Network Module
  class NetWork @Inject constructor(
    val retrofit: RetrofitService,
    val network: NetworkHandler
  ) : IngredientRepo {
    override fun getItemInfo(string: String): Either<Failure, AdapterItem> {
      return pullFromRequest(
        network,
        call = retrofit.singleFoodItem(
          app_id = RetrofitApi.AppId, app_key = RetrofitApi.AppKey, ingred = string
        ), validate = { a -> a.validateType() },
        transform = { a ->
          a.asJsonObject.mMapToObject()
        }, acceptunFormated = true
      )
    }

    //MARK:- get item naming
   override fun getItemInfoNaming(string: String): Either<Failure, NamingRequestModule> {
      return pullFromRequest(
        network,
        call = retrofit.singleFoodItemNaming(
          app_id = RetrofitApi.AppId, app_key = RetrofitApi.AppKey, ingred = string
        ), validate = { a -> a.validateType() },
        transform = { a ->
          a.asJsonObject.mMapToObject()
        }, acceptunFormated = true
      )
    }
  }
}