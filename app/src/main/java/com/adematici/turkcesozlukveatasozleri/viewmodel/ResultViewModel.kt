package com.adematici.turkcesozlukveatasozleri.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adematici.turkcesozlukveatasozleri.database.VeritabaniYardimcisi
import com.adematici.turkcesozlukveatasozleri.model.KelimeModel
import com.adematici.turkcesozlukveatasozleri.model.KelimeModelItem
import com.adematici.turkcesozlukveatasozleri.service.SozlukAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ResultViewModel: ViewModel() {

    private val service = SozlukAPIService()
    private val compositeDisposable = CompositeDisposable()

    val veriler = MutableLiveData<KelimeModel>()
    val errorMessage = MutableLiveData<Boolean>()
    val progressBar = MutableLiveData<Boolean>()

    fun verileriAl(kelime: String){
        getData(kelime)
    }

    private fun getData(kelime: String){
        progressBar.value = true
        compositeDisposable.add(service.getData(kelime)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableSingleObserver<KelimeModel>(){
                override fun onSuccess(t: KelimeModel) {
                    veriler.value = t
                    progressBar.value = false
                    errorMessage.value = false
                }
                override fun onError(e: Throwable) {
                    progressBar.value = false
                    errorMessage.value = true
                }
            }))
    }

}