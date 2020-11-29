package com.moneymanager.ui.recordlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.moneymanager.databinding.FragmentRecordListBinding
import com.moneymanager.ui.adapter.RecordListAdapter
import kotlinx.android.synthetic.main.fragment_record_list.*

/**
 * A fragment representing a list of Items.
 */
class RecordListFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentRecordListBinding
    private lateinit var adapter: RecordListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewDataBinding = FragmentRecordListBinding.inflate(inflater, container, false).apply {
            viewmodel = RecordListViewModel(context!!)
            setLifecycleOwner(viewLifecycleOwner)
        }

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding.viewmodel?.fetchRecordList()

        setupAdapter()
        setupObserver()
    }

    private fun setupAdapter(){

        adapter = RecordListAdapter()
        val layoutManager = LinearLayoutManager(activity)
        record_list_rv.layoutManager = layoutManager
        record_list_rv.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
        record_list_rv.adapter = adapter
    }

    private fun setupObserver(){

        viewDataBinding.viewmodel?.recordListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRecordList(it)
        })
    }
}