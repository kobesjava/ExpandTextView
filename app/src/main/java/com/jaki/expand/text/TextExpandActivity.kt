package com.jaki.expand.text

import android.content.Context
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.URLSpan
import android.text.util.Linkify
import androidx.appcompat.app.AppCompatActivity
import com.jaki.expand.R
import com.jaki.expand.span.JAtSpan
import kotlinx.android.synthetic.main.text_expand_activity.*
import java.util.regex.Pattern

class TextExpandActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_expand_activity)
        txt1.setData(2, getSpann("下雪了，互联网能创造价值，区块链行@JakiJaki\u2005吗？下雪了，@JakiJakiJaki 造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？"), "展开")
    }

    private fun getSpann(txt: String): CharSequence {
        val spann = SpannableString.valueOf(txt)
        Linkify.addLinks(spann, Pattern.compile("@[\\u4e00-\\u9fa5a-zA-Z0-9_-]+\\u2005", Pattern.CASE_INSENSITIVE), "at")
        val urlSpanArray = spann.getSpans(0, spann.length, URLSpan::class.java)
        val builder = SpannableStringBuilder(spann)
        for (urlSpan in urlSpanArray) {
            if (urlSpan.url.startsWith("at")) {
                val start = builder.getSpanStart(urlSpan)
                val end = builder.getSpanEnd(urlSpan)
                if (start >= 0 && end >= 0) {
                    builder.removeSpan(urlSpan)
                    val url = urlSpan.url
                    builder.replace(start, end, getAtTextSSBuilder(this, url))
                }
            }
        }
        builder.setSpan(ForegroundColorSpan(getColor(R.color.color_5187ff)), 70, 75, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return builder
    }

    private fun getAtTextSSBuilder(context: Context, atName: String): SpannableStringBuilder {
        val title = atName.substring(2)
        val builder = SpannableStringBuilder(title)
        val atSpan = JAtSpan(context, atName)
        builder.setSpan(atSpan, 0, title.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return builder
    }
}
