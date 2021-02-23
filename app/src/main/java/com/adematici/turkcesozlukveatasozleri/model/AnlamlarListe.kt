package com.adematici.turkcesozlukveatasozleri.model


import com.google.gson.annotations.SerializedName

data class AnlamlarListe(
    val anlam: String,
    @SerializedName("anlam_sira")
    val anlamSira: String
)