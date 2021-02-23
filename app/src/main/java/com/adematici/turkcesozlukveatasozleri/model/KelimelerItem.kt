package com.adematici.turkcesozlukveatasozleri.model


import com.google.gson.annotations.SerializedName

data class KelimelerItem(
    val anlamlarListe: List<AnlamlarListe>,
    val kac: String,
    val madde: String
)