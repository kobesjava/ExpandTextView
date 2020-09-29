package com.jaki.expand.text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jaki.expand.R
import kotlinx.android.synthetic.main.text_append_activity.*

class TextAppendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_append_activity)
        txt1.setData(2, "下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？", "(等待审核)")
    }
}
