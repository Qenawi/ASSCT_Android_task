package com.example.assc_android_task.domain.network

import com.example.assc_android_task.domain.dagger.modules.network.NetworkHandler
import com.google.gson.JsonElement
import org.json.JSONObject
import retrofit2.Call

//MARK:- Call network call and return Either<error, response>
fun <T : Any, R : Any> pullFromRequest(
  network: NetworkHandler,
  call: Call<T>,
  validate: (R?) -> Boolean,
  transform: (T) -> R?,
  acceptunFormated: Boolean = false
): Either<Failure, R> {
  return when (network.isConnected) {
    false, null -> Either.Left(Failure.NetworkConnection)
    else -> {
      refactorRequest(
        call,
        transform,
        validate,
        acceptunFormated
      )
    }
  }
}

fun <T, R> refactorRequest(
  call: Call<T>,
  transform: (T) -> R?,
  validate: (R?) -> Boolean,
  acceptunFormated: Boolean = false
): Either<Failure, R> {
  return try {
    val response = call.execute()
    when (response.isSuccessful) {
      true -> {

        val body = response.body()
        val eTrans =
          if (acceptunFormated) GeneralResponseObject() else (body as JsonElement).mMapToObject()
        eTrans?.let { aa ->
          if (aa.data != null || acceptunFormated) {
            val transOut = transform(body!!)
            val validOut = validate(transOut)
            if (validOut && transOut != null) {
              Either.Right(transOut)
            } else {
              Either.Left(
                Failure.EmptyResult.setArgs(
                  aa.message ?: "NetWork Error"
                )
              )
            }
          } else {
            Either.Left(
              Failure.EmptyResult.setArgs(
                aa.message ?: "NetWork Error"
              )
            )
          }//data object is null
        } ?: Either.Left(Failure.EmptyResult)
      }
      false -> {
        Either.Left(
          refactorErrorBodyToFail(
            response.errorBody()?.toString() ?: "NetWork Error"
          )
        )
      }
    }
  } catch (exception: Exception)
  {

    exception.printStackTrace()
    Either.Left(Failure.ServerError.setArgs(exception.message, exception))
  }
}
//MARK:- extract error message in case of network/server error

private fun refactorErrorBodyToFail(string: String): Failure {
  return try {
    val jObjError = JSONObject(string)
    val result = jObjError.mAnyToJsonElement().mMapToObject<GeneralResponseObject>()
    return Failure.EmptyResult.setArgs(
      result?.message
    )
  } catch (e: Exception) {
    e.printStackTrace()
    Failure.ServerError
  }
}

