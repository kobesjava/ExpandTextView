package com.jaki.expand.span

import android.content.Context
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

import com.jaki.expand.R

class JExpandSpan(private val context: Context) : ClickableSpan() {

    private val color: Int = R.color.color_5187ff

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.isUnderlineText = false
        ds.color = context.getColor(color)
    }

    override fun onClick(widget: View) {

    }
}