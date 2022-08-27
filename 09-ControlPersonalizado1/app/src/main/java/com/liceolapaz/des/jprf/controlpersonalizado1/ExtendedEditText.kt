package com.liceolapaz.des.jprf.controlpersonalizado1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class ExtendedEditText : AppCompatEditText {
    private val p1 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        style = Paint.Style.FILL
    }

    private val p2 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textSize = 30f
    }

    private val escala = resources.displayMetrics.density

    constructor(ctx: Context) : super(ctx)
    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        //Llamamos al método de la clase base (EditText)
        super.onDraw(canvas)

        //Dibujamos el fondo negro del contador
        canvas.drawRect(width - 30 * escala,
            5 * escala,
            width - 5 * escala,
            30 * escala, p1)

        //Dibujamos el número de caracteres sobre el contador
        canvas.drawText("" + text.toString().length,
            width - 25 * escala,
            20 * escala, p2)
    }
}