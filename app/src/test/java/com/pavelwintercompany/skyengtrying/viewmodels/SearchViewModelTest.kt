package com.pavelwintercompany.skyengtrying.viewmodels

import com.pavelwintercompany.skyengtrying.models.Meaning
import com.pavelwintercompany.skyengtrying.models.QueryResponseModel
import com.pavelwintercompany.skyengtrying.models.SearchPageModel
import com.pavelwintercompany.skyengtrying.models.Translation
import org.junit.Test

class SearchViewModelTest {

    @Test
    fun parseSearchResponse() {

        val etalon21str = "text21"
        val etalon1id = 1


        val responseModelList = arrayListOf(
            QueryResponseModel().apply {
                meanings = arrayListOf((Meaning().apply {
                    id = etalon1id
                    translation = Translation().apply { text = "text11" }
                    text = " text12"
                }))

            },
            QueryResponseModel().apply {
                meanings = arrayListOf((Meaning().apply {
                    id = 2
                    translation = Translation().apply { text = etalon21str }
                    text = " text22"
                }))

            }
        )

        val text21 = SearchViewModel().parseSearchResponse(responseModelList)[1].translatedWord
        val etal1id = SearchViewModel().parseSearchResponse(responseModelList)[0].wordId
        assert(text21.equals(etalon21str))
        assert(etal1id == etalon1id)

    }

    fun parseSearchResponse(response: List<QueryResponseModel>) = response.map { it ->
        SearchPageModel(
            it.meanings?.get(0)?.id,
            it.text,
            it.meanings?.get(0)?.translation?.text ?: ""
        )
    }

}