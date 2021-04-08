package com.example.lv2.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lv2.OnInspiringPersonSelectedListener
import com.example.lv2.R
import com.example.lv2.adapters.InspiringPeopleAdapter
import com.example.lv2.databinding.ActivityMainBinding
import com.example.lv2.fragments.InspiringPeopleListFragment
import com.example.lv2.fragments.InspiringPersonDetailsFragment
import com.example.lv2.model.InspiringPerson

class MainActivity : AppCompatActivity(), OnInspiringPersonSelectedListener {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fabAddPerson.setOnClickListener{createNewInspiringPerson()}
        setContentView(mainBinding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer,
                        InspiringPeopleListFragment.create(),
                        InspiringPeopleListFragment.TAG)
                .commit()
        }
    }

    private fun createNewInspiringPerson() {
        val newInspiringPersonIntent = Intent(this, NewInspiringPersonActivity::class.java)
        startActivity(newInspiringPersonIntent)
    }

    override fun onInspiringPersonSelected(inspiringPerson: InspiringPerson) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_fragmentContainer,
                    InspiringPersonDetailsFragment.create(inspiringPerson),
                    InspiringPersonDetailsFragment.TAG)
            .addToBackStack(null)
            .commit()
    }
}