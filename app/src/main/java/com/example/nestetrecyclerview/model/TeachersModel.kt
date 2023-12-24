package com.example.nestetrecyclerview.model

data class TeachersModel(

    val id: Int? = null,
    val name: String? = null,
    val contact: String? = null,
    val subject: String? = null,
    val students: List<StudentsModel>? = null
)
