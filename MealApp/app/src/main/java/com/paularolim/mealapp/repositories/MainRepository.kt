package com.paularolim.mealapp.repositories

import com.paularolim.mealapp.services.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getCategories() = retrofitService.getCategories()
}