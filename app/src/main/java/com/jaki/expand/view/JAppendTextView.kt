package com.jaki.expand.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.jaki.expand.R
import com.jaki.expand.extension.dp2px

class JAppendTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val textPaint = TextPaint()
    private val appendPaint = Paint()
    private var content: String = ""//"下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？下雪了，互联网能创造价值，区块链行吗？"
    private var appendText = ""
    private var limnitLine: Int = 0
    private val bounds = Rect()
    private var mheight = 0
    private var lineCount = 0
    private var lineStartIndex = 0
    private var lineEndIndex = 0

    init {
        textPaint.textSize = 16.dp2px().toFloat()
        textPaint.color = getContext().getColor(R.color.color_FF1A1A1A)
        textPaint.typeface = Typeface.DEFAULT_BOLD

        paint.color = getContext().getColor(R.color.color_FF1A1A1A)
        paint.textSize = 16.dp2px().toFloat()
        paint.typeface = Typeface.DEFAULT_BOLD

        appendPaint.color = getContext().getColor(R.color.color_5187ff)
        appendPaint.textSize = 16.dp2px().toFloat()
        appendPaint.typeface = Typeface.DEFAULT_BOLD
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (content.isNotEmpty()) {
            val staticLayout1 = StaticLayout(content + appendText, textPaint, MeasureSpec.getSize(widthMeasureSpec), Layout.Alignment.ALIGN_NORMAL, 1f, 5.dp2px().toFloat(), true)
            lineCount = staticLayout1.lineCount
            if (lineCount <= limnitLine || limnitLine <= 0) {
                mheight = staticLayout1.height
            } else {
                mheight = staticLayout1.getLineBottom(limnitLine - 1)
                lineStartIndex = staticLayout1.getLineStart(limnitLine - 1)
                lineEndIndex = staticLayout1.getLineEnd(limnitLine - 1)
                if (appendText.isNotEmpty() && lineEndIndex > content.length) {
                    lineEndIndex = content.length
                }
            }
            setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mheight)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }

    private fun checkLine(): Boolean {
        textPaint.getTextBounds(content + appendText, 0, content.length + appendText.length, bounds)
        return bounds.bottom > 16.dp2px() * limnitLine
    }

    fun setData(limnitLine: Int, content: String?, appendTxt: String?) {
        this.limnitLine = limnitLine
        this.content = content ?: ""
        this.appendText = appendTxt ?: ""
        requestLayout()
    }

    override fun onDraw(canvas: Canvas) {
        var drawText = content
        if (limnitLine in 1 until lineCount) {
            val line2DrawText = drawText.substring(lineStartIndex, lineEndIndex)
            var limit = 0
            while (true) {
                if (paint.measureText("${line2DrawText.substring(0, line2DrawText.length - limit)}...$appendText") <= width) {
                    break
                } else {
                    limit++
                }
            }
            drawText = drawText.substring(0, lineEndIndex - limit) + "..."
        }
        val staticLayout1 = StaticLayout(drawText, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1f, 5.dp2px().toFloat(), true)
        staticLayout1.draw(canvas)
        if (appendText.isNotEmpty()) {
            if (limnitLine in 1..lineCount) {
                canvas.drawText(appendText, staticLayout1.getLineRight(limnitLine - 1), staticLayout1.getLineBaseline(limnitLine - 1).toFloat(), appendPaint)
            } else {
                canvas.drawText(appendText, staticLayout1.getLineRight(lineCount - 1), staticLayout1.getLineBaseline(lineCount - 1).toFloat(), appendPaint)
            }
        }
    }

}