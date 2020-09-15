package com.pavelwintercompany.skyengtrying.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavelwintercompany.skyengtrying.models.WordDetailModel
import com.pavelwintercompany.skyengtrying.network.NetworkManager
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class WordDetailViewModel : ViewModel() {
    var wordDetailModel = MutableLiveData<WordDetailModel>()

    fun callWordDetails(wordId : Int){
        NetworkManager.getNetworkService()?.getDetailMeaning(wordId)
            ?.subscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )
            ?.subscribe { result ->

                result[0].let {
                    wordDetailModel.value= WordDetailModel(
                        it.wordId,
                        it.text,
                        it.translation?.text,
                        it.images?.get(0)?.url
                    )
                }
            };
    }
}