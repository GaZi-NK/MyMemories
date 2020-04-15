package com.example.redma.mymemories

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_slide.*
import kotlin.concurrent.timer

class SlideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        //pagerにFragmentpagerAdapterをセット
        pager.adapter = MyAdapter(supportFragmentManager)

        //5秒ごとに画像を入れ替える処理
        val handler = Handler() //Handlerクラスのインスタンスを作成
        //5秒ごとに実行
        timer(period = 5000){
            //SAM関数を使いobject:Runnale{override fun run(){}}を省略⇒本来はhandler.post{}の中にある
            handler.post{
                pager.currentItem = (pager.currentItem + 1) % 10
            }
        }
    }

    //アダプターを作成しViewPagerに関連付ける処理
    class MyAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
        private val resource = listOf(
            R.drawable.slide00, R.drawable.slide01, R.drawable.slide02, R.drawable.slide03,
            R.drawable.slide04, R.drawable.slide05, R.drawable.slide06, R.drawable.slide07,
            R.drawable.slide08, R.drawable.slide09
        )

        //表示する画像の総数を返す
        override fun getCount(): Int {
            return resource.size
        }

        //ページ番号を受け取り、対応するフラグメント返す
        override fun getItem(position: Int): Fragment {
            return ImageFragment.newInstance(resource[position])
        }
    }
}
