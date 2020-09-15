package com.pavelwintercompany.skyengtrying.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QueryResponseModel {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("meanings")
    @Expose
    var meanings: List<Meaning>? = null
}

class Meaning {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("partOfSpeechCode")
    @Expose
    var partOfSpeechCode: String? = null

    @SerializedName("translation")
    @Expose
    var translation: Translation? = null

    @SerializedName("previewUrl")
    @Expose
    var previewUrl: String? = null

    @SerializedName("imageUrl")
    @Expose
    var imageUrl: String? = null

    @SerializedName("transcription")
    @Expose
    var transcription: String? = null

    @SerializedName("soundUrl")
    @Expose
    var soundUrl: String? = null
}

class Translation {
    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("note")
    @Expose
    var note: String? = null
}