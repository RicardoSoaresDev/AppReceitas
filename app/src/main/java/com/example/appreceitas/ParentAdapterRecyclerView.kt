package com.example.appreceitas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appreceitas.databinding.ParentLayoutCardBinding

class ParentAdapterRecyclerView(
    var list: List<Pair<String, List<ModelParent>>>,
    val onClick: (Model) -> Unit
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ParentLayoutCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ParentViewHolder -> holder.bind(list[position], onClick)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ParentViewHolder(binding: ParentLayoutCardBinding) : RecyclerView.ViewHolder(binding.root) {

        private val section = binding.textViewSection
        private val recyclerView = binding.recyclerViewChild

        fun bind(
            modelParent: Pair<String, List<ModelParent>>,
            onClick: (Model) -> Unit
        ) {
            section.text = modelParent.first
            recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ChildAdapterRecyclerView(modelParent.second, onClick)
            }
        }
    }
}