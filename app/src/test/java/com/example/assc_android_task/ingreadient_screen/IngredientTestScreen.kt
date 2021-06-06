package com.example.assc_android_task.ingreadient_screen

import com.example.assc_android_task.domain.network.mMapToObject
import com.example.assc_android_task.domain.network.mStringToJsonElement
import com.example.assc_android_task.mock_server.MockServerResponse
import com.example.assc_android_task.ui.ingredient.model.AdapterItem
import junit.framework.Assert
import org.junit.Test

class IngredientTestScreen {
  @Test
  fun mainInputScreen() {
    Assert.assertEquals(4, 2 + 2)
  }

  //MARK:- test json mapping result to ui object
  @Test
  fun testIngredientResponseSuccess() {
    val json = MockServerResponse.validResponseIngredientItem.mStringToJsonElement()
      .mMapToObject<AdapterItem>()
    Assert.assertNotNull(json)
  }
  @Test
  fun testIngredientResponseFail() {
    val json = MockServerResponse.notValidResponseIngredientItem.mStringToJsonElement()
      .mMapToObject<AdapterItem>()
    Assert.assertNull(json?.weight)
  }
}