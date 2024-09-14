package ir.example.digikalaapp.repository

import ir.example.digikalaapp.data.model.home.Slider
import ir.example.digikalaapp.data.remote.BaseApiResponse
import ir.example.digikalaapp.data.remote.HomeApiInterface
import ir.example.digikalaapp.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val api: HomeApiInterface
) : BaseApiResponse() {

    suspend fun getSlider(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }
}