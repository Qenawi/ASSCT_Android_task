package com.example.assc_android_task.domain.network

import com.google.gson.JsonElement
import dagger.Provides
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitApi {
  companion object {
    val AppId = "16dd29a8"
    val AppKey = "dc5f77af3447602947a6a262c875c5e3"
    private const val single_food_item = "nutrition-data"
    private const val single_food_item_naming = "food-database/v2/parser"
    private const val nutrition_details = "nutrition-details"
  }

  @GET(single_food_item)
  fun singleFoodItem(
    @Query("app_id") app_id: String,
    @Query("app_key") app_key: String,
    @Query("ingr", encoded = false) ingred: String
  ): Call<JsonElement>

  @GET(single_food_item_naming)
  fun singleFoodItemNaming(
    @Query("app_id") app_id: String,
    @Query("app_key") app_key: String,
    @Query("ingr", encoded = false) ingred: String
  ): Call<JsonElement>

  @POST(nutrition_details)
  fun getRecipeDetails(
    @Query("app_id") app_id: String,
    @Query("app_key") app_key: String,
    @Body recipe: HashMap<String, Any>
  ): Call<JsonElement>
}
