package ir.example.digikalaapp.data.remote

import ir.example.digikalaapp.data.model.ResponseResult
import ir.example.digikalaapp.data.model.home.Slider
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {

    @GET("v1/getSlider")
    suspend fun getSlider():Response<ResponseResult<List<Slider>>>
}