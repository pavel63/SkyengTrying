package com.pavelwintercompany.skyengtrying.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.pavelwintercompany.skyengtrying.R
import com.pavelwintercompany.skyengtrying.models.SearchPageModel
import kotlinx.android.synthetic.main.first_page_item.view.*


class FirstPageAdapter(private val modelsList: List<SearchPageModel>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<FirstPageAdapter.MyHolder>() {

    private var listener: Listener? = null

    interface Listener {
        fun onItemClick(wordId: Int)
    }

    fun setOnItemClickListener(listener: Listener) {
        this.listener = listener
    }

    override fun getItemCount(): Int {
        return modelsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.first_page_item, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val itemModel = modelsList[position]
        holder.russianWord?.text = itemModel.russianWord
        holder.foreignWord?.text = itemModel.translatedWord
        holder.itemView.setOnClickListener {
            listener?.onItemClick(itemModel.wordId ?: 0)
        }
    }


    class MyHolder internal constructor(view: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var russianWord: TextView? = view.first_page_russian
        var foreignWord: TextView? = view.first_page_foreign
    }
}
