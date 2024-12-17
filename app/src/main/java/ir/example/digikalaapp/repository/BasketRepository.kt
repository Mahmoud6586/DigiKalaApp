package ir.example.digikalaapp.repository

import ir.example.digikalaapp.data.model.category.SubCategory
import ir.example.digikalaapp.data.model.home.AmazingItem
import ir.example.digikalaapp.data.model.home.MainCategory
import ir.example.digikalaapp.data.model.home.Slider
import ir.example.digikalaapp.data.model.home.StoreProduct
import ir.example.digikalaapp.data.remote.BaseApiResponse
import ir.example.digikalaapp.data.remote.BasketApiInterface
import ir.example.digikalaapp.data.remote.CategoryApiInterface
import ir.example.digikalaapp.data.remote.HomeApiInterface
import ir.example.digikalaapp.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: BasketApiInterface
) : BaseApiResponse() {

    suspend fun getSuggestedItems():NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }

}