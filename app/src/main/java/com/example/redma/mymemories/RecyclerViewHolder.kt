package com.example.redma.mymemories

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    var title : TextView = itemView.findViewById(R.id.title)
}