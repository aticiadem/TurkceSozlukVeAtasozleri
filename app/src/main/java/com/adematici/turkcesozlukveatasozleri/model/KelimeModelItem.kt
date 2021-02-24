package com.adematici.turkcesozlukveatasozleri.model

import com.google.gson.annotations.SerializedName

data class KelimeModelItem(
    val anlamlarListe: List<AnlamlarListe>,
    val atasozu: List<Atasozu>,
    val madde: String
)