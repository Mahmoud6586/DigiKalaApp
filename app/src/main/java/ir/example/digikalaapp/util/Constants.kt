package ir.example.digikalaapp.util

import ir.example.digikalaapp.BuildConfig

object Constants {

    const val ENGLISH_LANG = "en"
    const val PERSIAN_LANG = "fa"
    const val DATASTORE_NAME = "DIGIKALA_DATA_STORE"
    var USER_LANGUAGE = "USER_LANGUAGE"
    const val TIMEOUT_IN_SECOND: Long = 60
    const val API_KEY = BuildConfig.X_API_KEY

    const val BASE_URL = "https://truelearn-digikala.iran.liara.run/api/"
}