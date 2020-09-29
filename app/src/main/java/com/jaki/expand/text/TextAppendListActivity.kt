package com.jaki.expand.text

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaki.expand.R
import kotlinx.android.synthetic.main.text_append_list_activity.*
import kotlinx.android.synthetic.main.text_append_list_item_view.view.*

class TextAppendListActivity : AppCompatActivity() {

    val listData: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_append_list_activity)

        listData.add("111111")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下22222")
        listData.add("wwwwwwww")
        listData.add("ewewewewe")
        listData.add("cscsc")
        listData.add("34343434")
        listData.add("ffdf")
        listData.add("rerer")
        listData.add("gfdggdgh")
        listData.add("dhdhddh")
        listData.add("hdhdhd")
        listData.add("brhbtn")
        listData.add("kukyuk")
        listData.add("34353")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了")
        listData.add("cscs")
        listData.add("yru")
        listData.add("8686")
        listData.add("vvsv")
        listData.add("hjyjy")
        listData.add("svsg")
        listData.add("csvsghb")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("ppp下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        listData.add("下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？")
        recycleview.layoutManager = LinearLayoutManager(this)
        recycleview.adapter = MyAdapter()
    }

    inner class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = View.inflate(parent.context, R.layout.text_append_list_item_view, null)
            view.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder.itemView.txt1.setData(2, listData[position], "(等待审核)")
        }

        override fun getItemCount(): Int {
            return listData.size
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
