package es.sarascript.examenandroid

import com.google.gson.annotations.SerializedName

class ItemDto(
    //@SerializedName("id") val id: int,
    @SerializedName("name") val name: String,
    //@SerializedName("username") val username: String,
    @SerializedName("email") val mail: String,
    //@SerializedName("address") val address: List<String>,
    //@SerializedName("phone") val phone: String,
    @SerializedName("website") val web: String
    //@SerializedName("company") val company: List<String>
)