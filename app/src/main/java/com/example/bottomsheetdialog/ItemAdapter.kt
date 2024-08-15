package com.example.bottomsheetdialog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items:List<Item>,
    private val onClick:(Item)->Unit): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

        class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
            var titleTextView= view.findViewById<TextView>(R.id.titleTextView)
            fun bind(item: Item,onClick: (Item) -> Unit){
                titleTextView.text=item.title
                itemView.setOnClickListener {
                    onClick(item)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item= items[position]
         return holder.bind(item,onClick)
    }
}