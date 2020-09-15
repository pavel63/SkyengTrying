package com.pavelwintercompany.skyengtrying.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavelwintercompany.skyengtrying.databinding.ActivityMainBinding
import com.pavelwintercompany.skyengtrying.models.SearchPageModel
import com.pavelwintercompany.skyengtrying.ui.adapters.FirstPageAdapter
import com.pavelwintercompany.skyengtrying.viewmodels.SearchViewModel

const val WORD_ID_KEY = "WORD_ID_KEY"

class MainActivity : AppCompatActivity(), FirstPageAdapter.Listener {

    private lateinit var binding: ActivityMainBinding
    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSearchViewListener()
        initViewModel()
    }


    private fun initViewModel() {
        val factory: ViewModelProvider.Factory = ViewModelProvider.NewInstanceFactory()
        searchViewModel =
            ViewModelProvider(this, factory).get(SearchViewModel::class.java)
        searchViewModel.searchPageModel.observe(
            this,
            Observer<List<SearchPageModel>> { searchPageModel ->
                setupFirstPageAdapter(searchPageModel)
            })
    }

    private fun initSearchViewListener() {
        binding.searchWords.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                searchViewModel.callSearch(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
        })
    }

    private fun setupFirstPageAdapter(modelsList: List<SearchPageModel>) {
        val adapter = FirstPageAdapter(modelsList)
        binding.firstPageHintListRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.firstPageHintListRv.adapter = adapter
        adapter.setOnItemClickListener(this)
    }

    override fun onItemClick(wordId: Int) {
        val intent = Intent(this, WordDetailActivity::class.java)
        intent.putExtra(WORD_ID_KEY, wordId)
        startActivity(intent)
    }

}