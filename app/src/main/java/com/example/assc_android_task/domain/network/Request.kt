package com.example.assc_android_task.domain.network

import com.example.assc_android_task.domain.dagger.modules.network.NetworkHandler
import com.google.gson.JsonElement
import org.json.JSONObject
import retrofit2.Call

fun <T : Any, R : Any> pullFromRequest(
  network: NetworkHandler,
  call: retrofit2.Call<T>,
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
    response
    when (response.isSuccessful) {
      true -> {

        val body = response.body()
        val eTrans =
          if (acceptunFormated) GeneralResponseObject() else (body as JsonElement).mMapToObject<GeneralResponseObject>()
        eTrans?.let { aa ->
          if (aa.data != null || acceptunFormated) {
            val transOut = transform(body!!)
            val validOut = validate(transOut)
            if (validOut && transOut != null) {
              Either.Right(transOut)
            } else {
              Either.Left(
                Failure.EmptyResult.setArgs(
                  aa.message_one ?: aa.message_two ?: "UNKOWNERRO"
                )
              )
            }
          } else {
            Either.Left(
              Failure.EmptyResult.setArgs(
                aa.message_one ?: aa.message_two ?: aa.message_three ?: "unkown"
              )
            )
          }//data object is null
        } ?: Either.Left(Failure.EmptyResult)
      }
      false -> {
        Either.Left(
          refactorErrorBodyToFail(
            response.errorBody()?.toString() ?: ""
          )
        )
      }
    }
  } catch (exception: Exception) {

    exception.printStackTrace()
    Either.Left(Failure.ServerError.setArgs(exception.message, exception))
  }
}

private fun refactorErrorBodyToFail(string: String): Failure {
  return try {
    val jObjError = JSONObject(string)
    val result = jObjError.mAnyToJsonElement().mMapToObject<GeneralResponseObject>()
    return Failure.EmptyResult.setArgs(
      result?.message_one ?: result?.message_two ?: result?.message_three
    )
  } catch (e: Exception) {
    e.printStackTrace()
    Failure.ServerError
  }
}

