package es.sarascript.examenandroid

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiUtils {

    companion object {
        private fun generateOkHttpBuilder(): OkHttpClient {
            return OkHttpClient().newBuilder().build()
        }

        fun generateRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(AppConstants.ENDPOINT) // añadimos la url base de la API
                .client(generateOkHttpBuilder())
                .addConverterFactory(MoshiConverterFactory.create()) // añadimos la conversión de Moshi
                .build()
        }
    }
}