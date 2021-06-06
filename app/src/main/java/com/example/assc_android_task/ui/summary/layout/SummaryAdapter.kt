package com.example.assc_android_task.ui.summary.layout

import com.example.assc_android_task.R
import com.example.assc_android_task.domain.base.BaseAdapter
import com.example.assc_android_task.domain.base.BaseViewHolder
import com.example.assc_android_task.ui.summary.model.AdapterItem

//MARK:- SummaryAdapter @Docs
class SummaryAdapter(itemClick: (AdapterItem) -> Unit = {}) : BaseAdapter<AdapterItem>(
  itemClick
) {
  override fun layoutRes(): Int = R.layout.summary_item

  override fun onViewHolderCreated(viewHolder: BaseViewHolder<AdapterItem>) {
  }
}

