package ir.example.digikalaapp.repository

import ir.example.digikalaapp.data.model.home.AmazingItem
import ir.example.digikalaapp.data.model.home.MainCategory
import ir.example.digikalaapp.data.model.home.Slider
import ir.example.digikalaapp.data.model.home.StoreProduct
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

    suspend fun getAmazingItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingItems()
        }

    suspend fun getAmazingSuperMarketItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall { api.getAmazingSuperMarketItems() }

    suspend fun getProposalBanners(): NetworkResult<List<Slider>> =
        safeApiCall { api.getProposalBanners() }

    suspend fun getCategories(): NetworkResult<List<MainCategory>> =
        safeApiCall { api.getCategories() }

    suspend fun getCenterBanner(): NetworkResult<List<Slider>> =
        safeApiCall { api.getCenterBanners() }

    suspend fun getBestSellerItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall { api.getBestSellerItems() }

    suspend fun getMostVisitedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall { api.getMostVisitedItems() }

    suspend fun getMostFavoriteItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall { api.getMostFavoriteItems() }

}