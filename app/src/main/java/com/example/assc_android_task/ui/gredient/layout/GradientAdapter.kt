package com.example.assc_android_task.ui.gredient.layout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assc_android_task.R
import com.example.assc_android_task.ui.gredient.model.AdapterItem

class RecyclerViewAdapter : ListAdapter<AdapterItem, BaseViewHolder>(BaseItemCallback()) {
  val mCurrentList = arrayListOf<AdapterItem?>()

  private var position: Int = 0

  @LayoutRes
  fun layoutRes() = R.layout.gradient_item
  fun onViewHolderCreated(viewHolder: BaseViewHolder) {}
  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): BaseViewHolder {
    val binding = DataBindingUtil.inflate<ViewDataBinding>(
      LayoutInflater.from(parent.context),
      layoutRes(),
      parent,
      false
    )
    return BaseViewHolder(binding).apply {
      onViewHolderCreated(this)
    }
  }

  override fun onBindViewHolder(
    holder: BaseViewHolder,
    position: Int
  ) {
    holder.bind(getItem(position))
  }

  fun updateList(newList: List<AdapterItem>) {
    mCurrentList.addAll(newList)
    submitList(mCurrentList.toMutableList())
  }

  fun setList(newList: List<AdapterItem?>) {
    mCurrentList.clear()
    mCurrentList.addAll(newList)
    submitList(mCurrentList.toMutableList())
  }

  fun clearCurrentList() {
    mCurrentList.clear()
    submitList(mCurrentList.toMutableList())
  }
}

// MARK:- BaseViewHolder

class BaseViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
  fun bind(item: AdapterItem) {
    binding.setVariable(BR.item, item)
    binding.executePendingBindings()
  }
}

class BaseItemCallback : DiffUtil.ItemCallback<AdapterItem>() {
  override fun areItemsTheSame(
    oldItem: AdapterItem,
    newItem: AdapterItem
  ) =
    oldItem == newItem

  override fun areContentsTheSame(
    oldItem: AdapterItem,
    newItem: AdapterItem
  ) =
    oldItem.equals(newItem)
}

//Binding Adapter
// MARK : Extentions
@BindingAdapter("adapter")
fun setRecyclerAdapter(
  recyclerView: RecyclerView,
  adapter: RecyclerView.Adapter<*>?
) {
  adapter?.let {
    recyclerView.adapter = it
  }
}