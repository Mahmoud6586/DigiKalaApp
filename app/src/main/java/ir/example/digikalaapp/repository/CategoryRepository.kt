package ir.example.digikalaapp.repository

import ir.example.digikalaapp.data.model.category.SubCategory
import ir.example.digikalaapp.data.model.home.AmazingItem
import ir.example.digikalaapp.data.model.home.MainCategory
import ir.example.digikalaapp.data.model.home.Slider
import ir.example.digikalaapp.data.model.home.StoreProduct
import ir.example.digikalaapp.data.remote.BaseApiResponse
import ir.example.digikalaapp.data.remote.CategoryApiInterface
import ir.example.digikalaapp.data.remote.HomeApiInterface
import ir.example.digikalaapp.data.remote.NetworkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val api: CategoryApiInterface
) : BaseApiResponse() {

    suspend fun getSubCategories(): NetworkResult<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }



}