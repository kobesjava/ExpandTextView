package com.jaki.expand.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.text.*
import android.text.style.CharacterStyle
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.jaki.expand.R
import com.jaki.expand.extension.dp2px

class JExpandTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), View.OnClickListener {

    private val paint = Paint()
    private val textPaint = TextPaint()
    private val appendPaint = Paint()

    private var content: CharSequence = ""
    private var ssBuilder: SpannableStringBuilder? = null
    private var endText = ""
    private var limnitLine: Int = 0
    private var lineCount = 0
    private var lineStartIndex = 0
    private var lineEndIndex = 0

    private var layout: StaticLayout? = null

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

        setOnClickListener(this)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (content.isNotEmpty()) {
            val staticLayout1 = StaticLayout(content, textPaint, MeasureSpec.getSize(widthMeasureSpec), Layout.Alignment.ALIGN_NORMAL, 1f, 5.dp2px().toFloat(), true)
            lineCount = staticLayout1.lineCount
            val mHeight: Int
            if (lineCount <= limnitLine || limnitLine <= 0) {
                mHeight = staticLayout1.height
            } else {
                mHeight = staticLayout1.getLineBottom(limnitLine - 1)
                lineStartIndex = staticLayout1.getLineStart(limnitLine - 1)
                lineEndIndex = staticLayout1.getLineEnd(limnitLine - 1)
            }
            setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mHeight)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }

    fun setData(limnitLine: Int, content: CharSequence?, endText: String?) {
        this.limnitLine = limnitLine
        this.content = content ?: ""
        this.endText = endText ?: ""
        requestLayout()
    }

    override fun onDraw(canvas: Canvas) {
        var drawText = content
        if (limnitLine in 1 until lineCount) {
            val line2DrawText = drawText.substring(lineStartIndex, lineEndIndex)
            var limit = 0
            while (true) {
                if (paint.measureText("${line2DrawText.substring(0, line2DrawText.length - limit)}...  $endText") <= width) {
                    break
                } else {
                    limit++
                }
            }
            drawText = drawText.substring(0, lineEndIndex - limit) + "...  "
        }
        setUpSpan(drawText)
        layout = StaticLayout(ssBuilder, textPaint, width, Layout.Alignment.ALIGN_NORMAL, 1f, 5.dp2px().toFloat(), true)
        layout!!.draw(canvas)
        if (endText.isNotEmpty() && limnitLine in 1 until lineCount) {
            if (limnitLine in 1..lineCount) {
                canvas.drawText(endText, layout!!.getLineRight(limnitLine - 1), layout!!.getLineBaseline(limnitLine - 1).toFloat(), appendPaint)
            } else {
                canvas.drawText(endText, layout!!.getLineRight(lineCount - 1), layout!!.getLineBaseline(lineCount - 1).toFloat(), appendPaint)
            }
        }
    }

    override fun onClick(v: View) {
        if (endText.isNotEmpty() && limnitLine in 1 until lineCount) {
            limnitLine = Int.MAX_VALUE
            requestLayout()
        }
    }

    private fun setUpSpan(cont: CharSequence) {
        ssBuilder = SpannableStringBuilder(cont)
        if (cont.isNotEmpty() && content is Spannable) {
            val span = content as Spannable
            val spans = span.getSpans(0, content.length, CharacterStyle::class.java)
            spans.forEach {
                val start = span.getSpanStart(it)
                val end = span.getSpanEnd(it)
                if (start < cont.length) {
                    ssBuilder?.setSpan(it, start, if (end > cont.length) cont.length else end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        layout?.let { layout ->
            ssBuilder?.let {
                val action = event.action
                if (action == MotionEvent.ACTION_UP ||
                        action == MotionEvent.ACTION_DOWN) {
                    var x = event.x.toInt()
                    var y = event.y.toInt()
                    //x -= widget.getTotalPaddingLeft()
                    //y -= widget.getTotalPaddingTop()
                    x += scrollX
                    y += scrollY
                    val line = layout.getLineForVertical(y)
                    val off = layout.getOffsetForHorizontal(line, x.toFloat())
                    if (off >= ssBuilder!!.length) {
                        return super.onTouchEvent(event)
                    }
                    val link: Array<ClickableSpan> = it.getSpans(off, off, ClickableSpan::class.java)
                    if (link.isNotEmpty()) {
                        if (action == MotionEvent.ACTION_UP) {
                            link[0].onClick(this)
                        } else {
                            Selection.setSelection(it,
                                    it.getSpanStart(link[0]),
                                    it.getSpanEnd(link[0]))
                        }
                        return true
                    } else {
                        Selection.removeSelection(it)
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }


}