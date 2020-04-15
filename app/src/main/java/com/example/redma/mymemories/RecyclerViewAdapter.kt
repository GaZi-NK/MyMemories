package com.example.redma.mymemories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(list : MutableList<MemoriyData>) : RecyclerView.Adapter<RecyclerViewHolder>() {
    var m_line : Int = 0
    //データクラスの配列を用意
    var list : MutableList<MemoriyData> = list

    //一行文のレイアウト(RecyclerView_layout)をインフレートし、それを引数にホルダー(RecyclerViewHolder)を作成し返す
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var inflate = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout, parent, false)
        var vh = RecyclerViewHolder(inflate)
        return vh
    }

    //データクラス(MemoryData)のサイズを返す
    override fun getItemCount(): Int {
        return list.size
    }


    //editbtnボタンがクリック時のリスナーの宣言と登録
    lateinit var m_listener : View.OnClickListener
    fun editbtnOnItemClickListener(listener: View.OnClickListener) {
        m_listener = listener
    }

    //starbtnボタンがクリック時のリスナーの宣言と登録
    lateinit var s_listener : View.OnClickListener
    fun startbtnOnItemClickListener(listener: View.OnClickListener) {
        s_listener = listener
    }

    //MemoryData(データクラス)から一行文のデータを取得しViewHolder(RecyclerViewHolder)に表示させる
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val pos = position
        holder.title.text = list[position].title
        holder.editbtn.setOnClickListener {
            m_line = pos
            m_listener.onClick(it)
        }
        holder.startbtn.setOnClickListener{
            m_line = pos
            s_listener.onClick(it)
        }
    }

    fun getLine() : Int{
        return m_line
    }

}