package ir.example.digikalaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.example.digikalaapp.data.model.category.SubCategory
import ir.example.digikalaapp.data.model.home.AmazingItem
import ir.example.digikalaapp.data.model.home.MainCategory
import ir.example.digikalaapp.data.model.home.Slider
import ir.example.digikalaapp.data.model.home.StoreProduct
import ir.example.digikalaapp.data.remote.NetworkResult
import ir.example.digikalaapp.repository.CategoryRepository
import ir.example.digikalaapp.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {

    val subCategory = MutableStateFlow<NetworkResult<SubCategory>>(NetworkResult.Loading())




    suspend fun getAllDataFromServer() {
        viewModelScope.launch {

            //fire and forget
            launch {
                subCategory.emit(repository.getSubCategories())
            }



        }
    }


}