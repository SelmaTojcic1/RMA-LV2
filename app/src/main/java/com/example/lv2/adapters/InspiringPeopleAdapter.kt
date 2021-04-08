package com.example.lv2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lv2.OnInspiringPersonSelectedListener
import com.example.lv2.R
import com.example.lv2.model.InspiringPerson

class InspiringPeopleAdapter(
    inspiringPeople: List<InspiringPerson>,
    private val listenerInspiring: OnInspiringPersonSelectedListener
) : RecyclerView.Adapter<InspiringPeopleViewHolder>(){

    private val inspiringPeople: MutableList<InspiringPerson> = mutableListOf()
    init{
        refreshData(inspiringPeople)
    }

    fun refreshData(notes: List<InspiringPerson>) {
        this.inspiringPeople.clear()
        this.inspiringPeople.addAll(notes)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspiringPeopleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_inspiring_person, parent, false)
        return InspiringPeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: InspiringPeopleViewHolder, position: Int) {
        val inspiringPerson = inspiringPeople[position]
        holder.bind(inspiringPerson)
        holder.itemView.setOnClickListener {listenerInspiring.onInspiringPersonSelected(inspiringPerson)}
    }

    override fun getItemCount(): Int = inspiringPeople.size

}