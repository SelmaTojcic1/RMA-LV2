package com.example.lv2.model

import java.io.Serializable

data class InspiringPerson (
        var name: String,
        var date: String,
        var details: String,
        var imageUrl: String,
        val quotesList: MutableList<String>
    ) : Serializable