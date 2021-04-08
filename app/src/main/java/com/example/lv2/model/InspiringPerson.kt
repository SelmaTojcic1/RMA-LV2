package com.example.lv2.model

import java.io.Serializable

data class InspiringPerson (
    val name: String,
    val date: String,
    val details: String,
    val imageUrl: String,
    val quotesList: MutableList<String>
    ) : Serializable