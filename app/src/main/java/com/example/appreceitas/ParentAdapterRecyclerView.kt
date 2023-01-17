package com.example.appreceitas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.parent_layout_card.view.*

class ParentAdapterRecyclerView(var listParent: List<String>,
                                var listChild: MutableList<Model>,
                                val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.parent_layout_card, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ParentViewHolder -> {

                holder.itemView.textViewSection.text = listParent[position]

                // initialize child adapter
                holder.itemView.recyclerViewChild.apply {
                    if ()
                    this.adapter = ChildAdapterRecyclerView(listChild, context, onClick = {
                        val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(it)
                        findNavController().navigate(action)
                    })
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return listParent.size
    }

    class ParentViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)
}