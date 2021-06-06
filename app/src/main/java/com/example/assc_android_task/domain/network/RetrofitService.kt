package com.example.assc_android_task.domain.network

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

//MARK:- Retrofit Service instance
class RetrofitService @Inject constructor(retrofit: Retrofit) : RetrofitApi {
  private val api by lazy { retrofit.create(RetrofitApi::class.java) }
  override fun singleFoodItem(
    app_id: String,
    app_key: String,
    ingred: String
  ) = api.singleFoodItem(app_id, app_key, ingred)

  override fun singleFoodItemNaming(
    app_id: String,
    app_key: String,
    ingred: String
  ) = api.singleFoodItemNaming(app_id, app_key, ingred)

  override fun getRecipeDetails(
    app_id: String,
    app_key: String,
    recipe: HashMap<String, Any>
  ) = api.getRecipeDetails(app_id, app_key, recipe)
}


