package ir.example.digikalaapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.example.digikalaapp.data.model.home.Slider
import ir.example.digikalaapp.data.remote.NetworkResult
import ir.example.digikalaapp.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())

    suspend fun getSlider() {
        viewModelScope.launch {
            slider.emit(repository.getSlider())
        }
    }
}