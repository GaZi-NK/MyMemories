package com.example.redma.mymemories

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //アダプターのインスタンスを作成
        val adapter = RecyclerViewAdapter(createDataset())
        //レイアウトマネージャーのインスタンスを取得
        var lim = LinearLayoutManager(this)
        //ListViewにはない便利な機能の一つでレスポンシブにデータを表示するために使用するLayoutManagerを設定
        MemoriesView.layoutManager = lim
        //表示するデータの数が固定長であれば、リソースを有効活用し、パフォーマンスを向上させる設定
        MemoriesView.setHasFixedSize(true)
        //RecyclerView(MemoriewView)にアダプターをセット
        MemoriesView.adapter = adapter

        (MemoriesView.adapter as RecyclerViewAdapter).setOnItemClickListener(View.OnClickListener {
            val line: Int = adapter.getLine() //ここでm_lineの値を取得
            var intent = Intent(this, EditActivity::class.java);
            intent.putExtra("line", line);
            startActivity(intent);
        })

    }
    private fun createDataset() : MutableList<MemoriyData> {
        var  list : MutableList<MemoriyData> = mutableListOf()
        for (i in 0..50){
            var data = MemoriyData()
            data.title = "データ"+i
            list.add(data)
        }
        return list
    }
}
