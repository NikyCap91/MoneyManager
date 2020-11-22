package com.moneymanager.ui.adapter.viewHolders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.moneymanager.BR
import com.moneymanager.model.Record

class RecordListViewHolder constructor(
    private val dataBinding: ViewDataBinding
    ) : RecyclerView.ViewHolder(dataBinding.root){

    fun setup(record: Record) {

        dataBinding.setVariable(BR.record, record)
        dataBinding.executePendingBindings()
    }
}