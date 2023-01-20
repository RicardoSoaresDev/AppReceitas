package com.example.appreceitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.parent_layout_card.view.*

class ParentAdapterRecyclerView(
    var list: List<Pair<String, List<ModelParent>>>,
    val onClick: (Model) -> Unit
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_layout_card, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ParentViewHolder -> holder.bind(list[position], onClick)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ParentViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        private val section = itemview.textViewSection
        private val recyclerView = itemView.recyclerViewChild

        fun bind(
            modelParent: Pair<String, List<ModelParent>>,
            onClick: (Model) -> Unit
        ) {
            section.text = modelParent.first
            recyclerView.apply {
                layoutManager = LinearLayoutManager(itemView.context)
                adapter = ChildAdapterRecyclerView(modelParent.second, onClick)
            }
        }
    }
}