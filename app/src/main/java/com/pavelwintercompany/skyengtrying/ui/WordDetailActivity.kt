package com.pavelwintercompany.skyengtrying.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pavelwintercompany.skyengtrying.R
import com.pavelwintercompany.skyengtrying.databinding.WordDetailModelBinding
import com.pavelwintercompany.skyengtrying.models.WordDetailModel
import com.pavelwintercompany.skyengtrying.viewmodels.WordDetailViewModel
import com.squareup.picasso.Picasso

class WordDetailActivity : AppCompatActivity() {

    private lateinit var binding: WordDetailModelBinding
    lateinit var wordDetailsModel: WordDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_detail_model)

        binding = WordDetailModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wordId = intent.getIntExtra(WORD_ID_KEY, 0)

        initViewModel()
        wordDetailsModel.callWordDetails(wordId)
    }


    private fun initViewModel() {
        val factory: ViewModelProvider.Factory = ViewModelProvider.NewInstanceFactory()
        wordDetailsModel =
            ViewModelProvider(this, factory).get(WordDetailViewModel::class.java)
        wordDetailsModel.wordDetailModel.observe(
            this,
            Observer<WordDetailModel> { wordDetailModel ->
                setData(wordDetailModel)
            })
    }


    private fun setData(wordDetailModel: WordDetailModel) {

        binding.detailInitialWordTv.text = wordDetailModel.russianWord
        binding.detailTranslatedWordTv.text = wordDetailModel.translatedWord

        if (!wordDetailModel.wordImageUrl.isNullOrEmpty()) {
            Picasso.get()
                .load("https:${wordDetailModel.wordImageUrl}")
                .placeholder(R.drawable.ic_baseline_cloud_download_24)
                .error(R.drawable.ic_baseline_error_24)
                .into(binding.detailImageViewIv)
        }
    }
}