package com.adematici.turkcesozlukveatasozleri.service

import com.adematici.turkcesozlukveatasozleri.model.KelimeModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SozlukAPIService {

    private val BASE_URL = "https://sozluk.gov.tr/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(SozlukAPI::class.java)

    fun getData(kelime: String): Single<KelimeModel>{
        return api.getSozluk(kelime)
    }

}