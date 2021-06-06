package com.example.assc_android_task.ui.ingredient.layout

import com.example.assc_android_task.R
import com.example.assc_android_task.domain.base.BaseAdapter
import com.example.assc_android_task.domain.base.BaseViewHolder
import com.example.assc_android_task.ui.ingredient.model.AdapterItem

//MARK:- IngredientAdapter @Docs
class IngredientAdapter(itemClick: (AdapterItem) -> Unit = {}) : BaseAdapter<AdapterItem>(
  itemClick
) {
  override fun layoutRes(): Int = R.layout.ingredient_item

  override fun onViewHolderCreated(viewHolder: BaseViewHolder<AdapterItem>) {
  }
}