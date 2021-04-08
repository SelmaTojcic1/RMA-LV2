package com.example.lv2.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lv2.GlideApp
import com.example.lv2.R
import com.example.lv2.activities.NewInspiringPersonActivity
import com.example.lv2.databinding.FragmentInspiringPersonDetailsBinding
import com.example.lv2.model.InspiringPerson


class InspiringPersonDetailsFragment : Fragment(){

    lateinit var inspiringPersonDetailsBinding: FragmentInspiringPersonDetailsBinding

    companion object{
        const val TAG = "Details"
        private const val KEY = "InspiringPerson"

        fun create(inspiringPerson: InspiringPerson) : InspiringPersonDetailsFragment {
            val args = Bundle()
            args.putSerializable(KEY, inspiringPerson)
            val fragment = InspiringPersonDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inspiringPersonDetailsBinding = FragmentInspiringPersonDetailsBinding.inflate(
            inflater,
            container,
            false
        )

        arguments?.let {
            val inspiringPerson = it.getSerializable(KEY) as InspiringPerson
            inspiringPersonDetailsBinding.tvInspiringPersonName.text = inspiringPerson.name
            inspiringPersonDetailsBinding.tvInspiringPersonDate.text = inspiringPerson.date
            inspiringPersonDetailsBinding.tvInspiringPersonDetails.text = inspiringPerson.details

            GlideApp.with(this)
                .load(inspiringPerson.imageUrl)
                .placeholder(R.drawable.placeholder_person)
                .centerCrop()
                .into(inspiringPersonDetailsBinding.ivInspiringPersonPhoto)
        }

        //napravit da uredi
        inspiringPersonDetailsBinding.btnEditInformation.setOnClickListener {
            val intent = Intent(activity,  NewInspiringPersonActivity::class.java)
            startActivity(intent)
        }

        return inspiringPersonDetailsBinding.root
    }


}