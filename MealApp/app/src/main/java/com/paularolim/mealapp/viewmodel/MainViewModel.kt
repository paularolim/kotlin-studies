package com.paularolim.mealapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paularolim.mealapp.data.Category
import com.paularolim.mealapp.data.CategoryResponse
import com.paularolim.mealapp.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val categories = MutableLiveData<List<Category>>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun getCategories() {
        loading.postValue(true)

        val response = repository.getCategories()
        response.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                categories.postValue(response.body()?.categories)
                loading.postValue(false)
            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
                loading.postValue(false)
            }
        })
    }

}