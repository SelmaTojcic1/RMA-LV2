package com.example.lv2.adapters

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lv2.GlideApp
import com.example.lv2.R
import com.example.lv2.databinding.ItemInspiringPersonBinding
import com.example.lv2.model.InspiringPerson

class InspiringPeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(inspiringPerson: InspiringPerson) {
        val itemInspiringPersonBinding = ItemInspiringPersonBinding.bind(itemView)

        itemInspiringPersonBinding.tvInspiringPersonItemName.text = inspiringPerson.name
        itemInspiringPersonBinding.tvInspiringPersonItemDetails.text = inspiringPerson.details
        itemInspiringPersonBinding.tvInspiringPersonItemDate.text = inspiringPerson.date

        GlideApp.with(itemView)
            .load(inspiringPerson.imageUrl)
            .placeholder(R.drawable.placeholder_person)
            .centerCrop()
            .into(itemInspiringPersonBinding.ivInspiringPersonItemPhoto)

        itemInspiringPersonBinding.ivInspiringPersonItemPhoto.setOnClickListener {
            Toast.makeText(itemInspiringPersonBinding.ivInspiringPersonItemPhoto.context,
                    inspiringPerson.quotesList.random(),
                    Toast.LENGTH_SHORT).show()
        }
    }

}