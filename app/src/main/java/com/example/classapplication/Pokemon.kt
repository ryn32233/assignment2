package com.example.classapplication

data class Pokemon (
    val name: String,
    val type: String,
    val dexNo: Int,
    val region: String,
    val image: String,
    val description: String,
    val id: Int,
    val relation: List<Int>

)