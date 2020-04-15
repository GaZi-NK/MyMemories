package com.example.redma.mymemories

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_image.*

//Bundleオブジェクトに値を格納したり取り出したりするときに使用するキーの宣言
val IMG_RES_ID = "IMG_RES_ID"
class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    //コンパニオンオブジェクト⇒Javaでいうstaticメソッド、ここでオブジェクト作成＆アーギュメンツにデータを格納する(アーギュメンツはフラグメントを再作成するときに使用するもの)
    companion object {
        fun newInstance(imageResurceId: Int) : ImageFragment {
            val bundle = Bundle()
            bundle.putInt(IMG_RES_ID, imageResurceId)
            val imageFragment = ImageFragment()
            imageFragment.arguments = bundle //アーギュメンツはBundleオブジェクト
            return imageFragment
        }
    }

    //アーギュメンツから値を取り出す処理
    private var imgResId: Int? = null //取り出した値をのリソースIDを保持する変数
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //letは{}内はletの左の変数をitして扱える⇒argumetsプロパティ
        arguments?.let{
            imgResId = it.getInt(IMG_RES_ID)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imgResId?.let{
            imageView.setImageResource(it)
        }
    }
}
