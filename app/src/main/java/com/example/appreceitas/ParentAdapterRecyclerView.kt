package com.example.appreceitas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.parent_layout_card.view.*

class ParentAdapterRecyclerView(var list: MutableList<ModelParent>,
//    var listParent: List<String>,
//    var listChild: MutableList<Model>,
    val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.parent_layout_card, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ParentViewHolder -> {

                val listType = mapOf(list[position].type to list)

                for (item in list) {
                    if (item.type != list[position].type) {
                        holder.itemView.textViewSection.text = list[position].type

                        // initialize child adapter
                        holder.itemView.recyclerViewChild.apply {
                            this.adapter = ChildAdapterRecyclerView(
                                list[position].recipeInfo,
                                context, onClick = {
                                    val action =
                                        ThirdFragmentDirections.actionThirdFragmentToFourthFragment(
                                            it
                                        )
                                    findNavController().navigate(action)
                                })
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ParentViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)
}