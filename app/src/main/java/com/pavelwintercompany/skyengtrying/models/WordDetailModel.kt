package com.pavelwintercompany.skyengtrying.models

data class WordDetailModel(
    var wordId: Int? = null,
    var russianWord: String? = null,
    var translatedWord: String? = null,
    var wordImageUrl: String? = null
)