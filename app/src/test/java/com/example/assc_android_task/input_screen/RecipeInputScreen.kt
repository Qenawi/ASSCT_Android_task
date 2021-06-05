package com.example.assc_android_task.input_screen

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import org.junit.Test

class RecipeInputScreen {
  @Test
  fun mainInputScreen() {
    assertEquals(4, 2 + 2)
  }

  //MARK:- test input text rule @contains(\n)
  @Test
  fun testTextValidationSuccess() {
    val input = "one cup pf rice ,\n one apple"
    val inputArray = if (input.contains("\n")) input.split("\n") else null
    assertNotNull(inputArray)
  }

  @Test
  fun testTextValidationFail() {
    val input = ""
    val inputArray = if (input.contains("\n")) input.split("\n") else null
    assertNull(inputArray)
  }
}