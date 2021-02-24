package com.adematici.turkcesozlukveatasozleri.service

import com.adematici.turkcesozlukveatasozleri.model.KelimeModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SozlukAPI {
    @GET("gts")
    fun getSozluk(
        @Query("ara") kelime: String
    ) : Single<KelimeModel>
}