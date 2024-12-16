package ir.example.digikalaapp.data.remote

import ir.example.digikalaapp.data.model.ResponseResult
import ir.example.digikalaapp.data.model.category.SubCategory
import ir.example.digikalaapp.data.model.home.AmazingItem
import ir.example.digikalaapp.data.model.home.MainCategory
import ir.example.digikalaapp.data.model.home.Slider
import ir.example.digikalaapp.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApiInterface {

    @GET("v1/getSubCategories")
    suspend fun getSubCategories(): Response<ResponseResult<SubCategory>>


}