package ir.example.digikalaapp.data.remote

import ir.example.digikalaapp.data.model.ResponseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Error

abstract class BaseApiResponse {

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<ResponseResult<T>>): NetworkResult<T> =
        withContext(Dispatchers.IO){
            try {
                val response = apiCall()
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        return@withContext NetworkResult.Success(body.message, body.data)
                    }
                }
                return@withContext error(errorMessage = "code : ${response.code()} , message : ${response.message()}")

            } catch (e: Exception) {
                return@withContext error(e.message ?: e.toString())
            }

        }



    private fun <T> error(errorMessage: String): NetworkResult<T> =
        NetworkResult.Error(message = "Api call failed : $errorMessage")
}

