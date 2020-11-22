package com.moneymanager.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.moneymanager.databinding.ViewRecordListItemBinding
import com.moneymanager.model.Record
import com.moneymanager.ui.adapter.viewHolders.RecordListViewHolder


class RecordListAdapter() : RecyclerView.Adapter<RecordListViewHolder>() {

    var recordList: List<Record> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewRecordListItemBinding.inflate(inflater,parent,false)

        return RecordListViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: RecordListViewHolder, position: Int) {
        holder.setup(recordList[position])
    }

    override fun getItemCount() = recordList.size

    fun updateRecordList(recordList: List<Record>){
        this.recordList = recordList
        notifyDataSetChanged()
    }
}