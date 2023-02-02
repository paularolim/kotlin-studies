package com.paularolim.fragments

import java.io.Serializable

data class Character(
    val name: String,
    val description: String,
    val imageResourceId: Int
) : Serializable