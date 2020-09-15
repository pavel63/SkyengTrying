package com.pavelwintercompany.skyengtrying.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DetailResponseModel {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("wordId")
    @Expose
    var wordId: Int? = null

    @SerializedName("difficultyLevel")
    @Expose
    var difficultyLevel: Int? = null

    @SerializedName("partOfSpeechCode")
    @Expose
    var partOfSpeechCode: String? = null

    @SerializedName("prefix")
    @Expose
    var prefix: String? = null

    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("soundUrl")
    @Expose
    var soundUrl: String? = null

    @SerializedName("transcription")
    @Expose
    var transcription: String? = null

    @SerializedName("updatedAt")
    @Expose
    var updatedAt: String? = null

    @SerializedName("mnemonics")
    @Expose
    var mnemonics: String? = null

    @SerializedName("translation")
    @Expose
    var translation: Translation? = null

    @SerializedName("images")
    @Expose
    var images: List<Image>? =
        null

    @SerializedName("definition")
    @Expose
    var definition: Definition? = null

    @SerializedName("examples")
    @Expose
    var examples: List<TextSoundUrl>? = null

    @SerializedName("meaningsWithSimilarTranslation")
    @Expose
    var meaningsWithSimilarTranslation: List<MeaningsWithSimilarTranslation>? =
        null

    @SerializedName("alternativeTranslations")
    @Expose
    var alternativeTranslations: List<AlternativeTranslation>? = null

}

class AlternativeTranslation {
    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("translation")
    @Expose
    var translation: Translation? = null

}

class Definition {
    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("soundUrl")
    @Expose
    var soundUrl: String? = null

}

class TextSoundUrl {
    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("soundUrl")
    @Expose
    var soundUrl: String? = null

}

class Image {
    @SerializedName("url")
    @Expose
    var url: String? = null

}

class MeaningsWithSimilarTranslation {
    @SerializedName("meaningId")
    @Expose
    var meaningId: Int? = null

    @SerializedName("frequencyPercent")
    @Expose
    var frequencyPercent: String? = null

    @SerializedName("partOfSpeechAbbreviation")
    @Expose
    var partOfSpeechAbbreviation: String? = null

    @SerializedName("translation")
    @Expose
    var translation: Translation? = null

}

/*class Translation {
    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("note")
    @Expose
    var note: String? = null

}

 */