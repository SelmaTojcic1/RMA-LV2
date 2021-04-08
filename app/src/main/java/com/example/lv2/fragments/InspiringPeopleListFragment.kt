package com.example.lv2.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lv2.InspiringPeopleRepository
import com.example.lv2.OnInspiringPersonSelectedListener
import com.example.lv2.databinding.FragmentInspiringPeopleListBinding
import com.example.lv2.adapters.InspiringPeopleAdapter

class InspiringPeopleListFragment: Fragment() {

    private lateinit var  onInspiringInspiringPersonSelectedListener: OnInspiringPersonSelectedListener
    private lateinit var  inspiringPeopleListBinding: FragmentInspiringPeopleListBinding
    private val inspiringPeopleRepository = InspiringPeopleRepository

    companion object {
        const val TAG = "List"
        fun create(): InspiringPeopleListFragment {
            return InspiringPeopleListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inspiringPeopleListBinding = FragmentInspiringPeopleListBinding.inflate(
            inflater,
            container,
            false
        )
        setupRecyclerView()

        return inspiringPeopleListBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnInspiringPersonSelectedListener){
            onInspiringInspiringPersonSelectedListener = context
        }
    }

    override fun onResume() {
        super.onResume()
        (inspiringPeopleListBinding.rvInspiringPeople.adapter as InspiringPeopleAdapter)
            .refreshData(inspiringPeopleRepository.getInspiringPeople())
    }

    private fun setupRecyclerView() {
        inspiringPeopleListBinding.rvInspiringPeople.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        inspiringPeopleListBinding.rvInspiringPeople.adapter =
            InspiringPeopleAdapter(inspiringPeopleRepository.getInspiringPeople(), onInspiringInspiringPersonSelectedListener)
    }
}