package com.example.assc_android_task.domain.base

import android.app.Application
import android.content.Context
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.assc_android_task.domain.dagger.application.ASSCTApplication
import com.example.assc_android_task.domain.network.Failure
import com.example.assc_android_task.domain.network.setArgs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

//MARK:- BaseViewModel @Docs
open class BaseViewModel<T>(
  application: Application,
  private val useCase: T
) : AndroidViewModel(application) {
  val toastMutable: MutableLiveData<Failure> = MutableLiveData()
  val obsShowProgressBar = ObservableBoolean(false)

  /**
   * This is the job for all coroutines started by this ViewModel.
   * Cancelling this job will cancel all coroutines started by this ViewModel.
   */
  val job = Job()

  /**
   * This is the main scope for all coroutines launched by MainViewModel.
   * Since we pass viewModelJob, you can cancel all coroutines
   * launched by uiScope by calling viewModelJob.cancel()
   */
  val uiScope = CoroutineScope(Dispatchers.Main + job)

  protected fun handleFailure(failure: Failure) {
    this.toastMutable.value = failure
  }

  /**
   * Cancel all coroutines when the ViewModel is cleared
   */
  override fun onCleared() {
    super.onCleared()
    if (useCase is BaseUseCase) useCase.onCleared()
  }

  fun setError(message: String?) {
    val f = Failure.ValidationError.setArgs(message, null)
    toastMutable.postValue(f)
    closeProgress()
  }

  fun showProgress() {
    obsShowProgressBar.set(true)
  }

  fun closeProgress() {
    obsShowProgressBar.set(false)
  }
}

//MARK:- ViewModel Extensions

inline fun <reified T : ViewModel> Fragment.viewModel(
  factory: ViewModelProvider.Factory,
  body: T.() -> Unit = {}
): T {
  val vm = ViewModelProviders.of(this, factory)[T::class.java]
  vm.body()
  return vm
}

inline fun <reified T : ViewModel> Fragment.viewModel(body: T.() -> Unit): T {
  val vm = ViewModelProviders.of(this)[T::class.java]
  vm.body()
  return vm
}

fun <B : ViewDataBinding> BaseFragment.binding(container: ViewGroup): B =
  DataBindingUtil.inflate(layoutInflater, layoutId(), container, false)

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(
  liveData: L,
  body: (T?) -> Unit
) {

  // todo mange lifeCycle
  liveData.observe(this, Observer(body))
}
