package com.example.assc_android_task.recipe_screen

import com.example.assc_android_task.domain.network.mMapToObject
import com.example.assc_android_task.domain.network.mStringToJsonElement
import com.example.assc_android_task.mock_server.MockServerResponse
import com.example.assc_android_task.ui.summary.model.SummaryRequestModel
import junit.framework.Assert
import org.junit.Test

class RecipeTestScreen {
  @Test
  fun mainInputScreen() {
    Assert.assertEquals(4, 2 + 2)
  }

  //MARK:- test json mapping result to ui object
  @Test
  fun testIngredientResponseSuccess() {
    val json = MockServerResponse.validResponseRecipe.mStringToJsonElement()
      .mMapToObject<SummaryRequestModel>()
    Assert.assertNotNull(json?.calories)
  }
  @Test
  fun testIngredientResponseFail() {
    val json = MockServerResponse.notValidResponseRecipe.mStringToJsonElement()
      .mMapToObject<SummaryRequestModel>()
    Assert.assertNull(json?.calories)
  }
}