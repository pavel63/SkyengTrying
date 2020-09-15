package com.pavelwintercompany.skyengtrying.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavelwintercompany.skyengtrying.models.QueryResponseModel
import com.pavelwintercompany.skyengtrying.models.SearchPageModel
import com.pavelwintercompany.skyengtrying.network.NetworkManager
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class SearchViewModel : ViewModel() {

    var searchPageModel = MutableLiveData<List<SearchPageModel>>()

    fun callSearch(queryString: String) {
        NetworkManager.getNetworkService()?.getSearchList(queryString)
            ?.subscribeOn(Schedulers.io())?.observeOn(
                AndroidSchedulers.mainThread()
            )
            ?.subscribe { result ->
                searchPageModel.value = parseSearchResponse(result)
            };
    }


     fun parseSearchResponse(response: List<QueryResponseModel>) = response.map { it ->
        SearchPageModel(
            it.meanings?.get(0)?.id,
            it.text,
            it.meanings?.get(0)?.translation?.text ?: ""
        )
    }

}