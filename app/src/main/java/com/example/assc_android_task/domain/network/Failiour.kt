package com.example.assc_android_task.domain.network

sealed class Failure {
  // external
  object NetworkConnection : Failure()// failed to connect to network
  {
    override var f_causeSt: String? = "لا يمكن الاتصال بالانترنت"
    override var f_causeTh: Throwable? = null
  }

  // server has empty response or useless response
  object ServerError : Failure() {
    override var f_causeSt: String? = "لم يتم ايجاد بيانات .."
    override var f_causeTh: Throwable? = null
  }

  // request has been sent but it has the wrong response
  object RequestError : Failure() {
    override var f_causeSt: String? = "برجاء تفقد البيانات المرسله واعاده الارسال"
    override var f_causeTh: Throwable? = null
  }

  object LocationUnknownFail : Failure() {
    override var f_causeSt: String? = "برجاء تشغيل ال  اللوكيشن وتفقد اتصالك بالانترنيت"
    override var f_causeTh: Throwable? = null
  }

  //internal
  object LocationHighAcc : Failure() {
    override var f_causeSt: String? = "برجاء تعديل اللوكيشن لوضع <High Accuracy>"
    override var f_causeTh: Throwable? = null
  }

  object EmptyResult : Failure() {
    override var f_causeSt: String? = "لم ايجاد بينات بماء علي اختيارك"
    override var f_causeTh: Throwable? = null
  }

  object SecurityError : Failure()// permissions
  {
    override var f_causeSt: String? = "برجاء اعطاء التطبيق الصلاحيات المطلوبه للمتابعه"
    override var f_causeTh: Throwable? = null
  }

  object ValidationError : Failure()// permissions
  {
    override var f_causeSt: String? = "من فضلك ادخل بيناتك بطريقه صحيحه"
    override var f_causeTh: Throwable? = null
  }

  // base params for failure cause
  abstract var f_causeTh: Throwable?//only for future use and as fall safe
  abstract var f_causeSt: String?

  //------------------------------------
  abstract class FeatureFailure : Failure() // todo Refactor
}

fun <T : Failure> T.setArgs(
  str: String?,
  thr: Throwable? = null
): T {
  this.f_causeSt = str
  this.f_causeTh = thr
  return this
}

fun <T : Failure> T.fast_int(f: Failure): T {
  this.f_causeSt = f.f_causeSt
  this.f_causeTh = f.f_causeTh
  return this
}
