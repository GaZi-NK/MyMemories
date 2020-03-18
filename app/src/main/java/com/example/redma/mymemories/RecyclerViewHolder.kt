package com.example.redma.mymemories

import android.content.ContentValues.TAG
import android.media.Image
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    var title : TextView = itemView.findViewById(R.id.title)
    var starbtn : ImageButton = itemView.findViewById(R.id.startbtn)
    var editbtn : ImageButton = itemView.findViewById(R.id.editbtn)
    var deletebtn : ImageButton = itemView.findViewById(R.id.deletebtn)

    interface ListListener{
        fun onItemClick(tappedView: View, position: Int)
    }
}