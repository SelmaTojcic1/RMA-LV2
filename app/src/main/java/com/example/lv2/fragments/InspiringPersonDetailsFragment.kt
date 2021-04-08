package com.example.lv2.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.lv2.GlideApp
import com.example.lv2.InspiringPeopleRepository
import com.example.lv2.R
import com.example.lv2.activities.NewInspiringPersonActivity
import com.example.lv2.databinding.FragmentInspiringPersonDetailsBinding
import com.example.lv2.model.InspiringPerson


class InspiringPersonDetailsFragment : Fragment(){

    lateinit var inspiringPersonDetailsBinding: FragmentInspiringPersonDetailsBinding
    private val inspiringPeopleRepository = InspiringPeopleRepository

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

        setHasOptionsMenu(true)

        return inspiringPersonDetailsBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete) {
            deleteInspiringPerson()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteInspiringPerson() {
        arguments?.let {
            val inspiringPerson = it.getSerializable(KEY) as InspiringPerson

            val builder = AlertDialog.Builder(requireContext())

            builder.setTitle("Are you sure you want to delete this person?")
                    .setPositiveButton("Yes") { _, _ ->
                        inspiringPeopleRepository.delete(inspiringPerson)
                    }
                    .setNegativeButton("No", DialogInterface.OnClickListener { dialog, _ ->
                        dialog.cancel()
                    })
                    .create()
                    .show()
        }
    }
}