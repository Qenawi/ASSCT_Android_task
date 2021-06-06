package com.example.assc_android_task.mock_server

//MARK:- server response mocking module
object MockServerResponse {
  //MARK:- Ingredient item response
  const val validResponseIngredientItem =
    "{ \"uri\": \"http://www.edamam.com/ontologies/edamam.owl#recipe_97c3dadb0e94473a808e5ca36cbaafe6\",\n" +
      "    \"calories\": 115,\n" +
      "    \"totalWeight\": 223.0,\n" +
      "    \"dietLabels\": [\n" +
      "        \"LOW_FAT\",\n" +
      "        \"LOW_SODIUM\"\n" +
      "    ]}"
  const val notValidResponseIngredientItem = "{}"

  //MARK:- Ingredient item response
  val validResponseRecipe =
    "{    \"uri\": \"http://www.edamam.com/ontologies/edamam.owl#recipe_57595d5e49f34ca1905cb262e06e2fbe\",\n" +
      "    \"yield\": 48.0,\n" +
      "    \"calories\": 18528,\n" +
      "    \"totalWeight\": 7980.792295779999,\n" +
      "    \"dietLabels\": [\n" +
      "        \"LOW_CARB\"\n" +
      "    ]}"
  val notValidResponseRecipe = "{}"
}