package ir.example.digikalaapp.util

import android.content.Context
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration
import org.intellij.lang.annotations.Language
import java.util.Locale

object LocaleUtils {


    fun setLocale(context: Context, language: String) = updateResource(context, language)

    private fun updateResource(context: Context, language: String) {

        context.resources.apply {
            val locale = Locale(language)
            val config = android.content.res.Configuration(configuration)

            context.createConfigurationContext(configuration)
            Locale.setDefault(locale)
            config.setLocale(locale)
            context.resources.updateConfiguration(config, displayMetrics)
        }
    }
}