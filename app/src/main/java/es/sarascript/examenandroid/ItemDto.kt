package es.sarascript.examenandroid

import com.google.gson.annotations.SerializedName

class ItemDto(
    @SerializedName("name") val name: String,
    @SerializedName("email") val mail: String,
    @SerializedName("website") val web: String
)