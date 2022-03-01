package com.example.calculate_zhx

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.tencent.mmkv.MMKV

/**
 * 计算
 */
class MainActivity : AppCompatActivity() {
    private val m1: TextView by lazy { findViewById(R.id.m1) }
    private val m2: TextView by lazy { findViewById(R.id.m2) }
    private val m3: TextView by lazy { findViewById(R.id.m3) }
    private val m4: TextView by lazy { findViewById(R.id.m4) }
    private val m5: TextView by lazy { findViewById(R.id.m5) }
    private val m6: TextView by lazy { findViewById(R.id.m6) }
    private val m7: TextView by lazy { findViewById(R.id.m7) }
    private val m8: TextView by lazy { findViewById(R.id.m8) }
    private val m9: TextView by lazy { findViewById(R.id.m9) }
    private val m10: TextView by lazy { findViewById(R.id.m10) }
    private val m11: TextView by lazy { findViewById(R.id.m11) }
    private val m12: TextView by lazy { findViewById(R.id.m12) }
    private val m13: TextView by lazy { findViewById(R.id.m13) }
    private val m14: TextView by lazy { findViewById(R.id.m14) }
    private val m15: TextView by lazy { findViewById(R.id.m15) }
    private val m16: TextView by lazy { findViewById(R.id.m16) }
    private val m17: TextView by lazy { findViewById(R.id.m17) }
    private val m18: TextView by lazy { findViewById(R.id.m18) }
    private val m19: TextView by lazy { findViewById(R.id.m19) }
    private val m20: TextView by lazy { findViewById(R.id.m20) }

    /**
     *
     */
    private val p1: TextView by lazy { findViewById(R.id.p1) }
    private val p2: TextView by lazy { findViewById(R.id.p2) }
    private val p3: TextView by lazy { findViewById(R.id.p3) }
    private val p4: TextView by lazy { findViewById(R.id.p4) }
    private val p5: TextView by lazy { findViewById(R.id.p5) }
    private val p6: TextView by lazy { findViewById(R.id.p6) }
    private val p7: TextView by lazy { findViewById(R.id.p7) }
    private val p8: TextView by lazy { findViewById(R.id.p8) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MMKV.initialize(this)
        setContentView(R.layout.activity_main)
        m1.init()
        m2.init()
        m3.init()
        m4.init()
        m5.init()
        m6.init()
        m7.init()
        m8.init()
        m9.init()
        m10.init()
        m11.init()
        m12.init()
        m13.init()
        m14.init()
        m15.init()
        m16.init()
        m17.init()
        m18.init()
        m19.init()
        m20.init()
        calculateResult()
    }


    fun onclick(view: View) {
        calculateResult()
    }

    private fun calculateResult() {
        // p1 = m1 + m2
        val tp1 = plus(0f, m1, m2)
        p1.text = tp1.first
        // p2 = m3 + m4 + m5
        val tp2 = plus(0f, m3, m4, m5)
        p2.text = tp2.first
        // p3 = m6 + m7
        val tp3 = plus(0f, m6, m7)
        p3.text = tp3.first
        // p4 = p1 * m8 * m9 * m10
        val tp4 = product(tp1.second, m8, m9, m10)
        p4.text = tp4.first
        // p5 = p2 * m11 * m12
        val tp5 = product(tp2.second, m11, m12)
        p5.text = tp5.first
        // p6 = p3 * m13 * m14
        val tp6 = product(tp3.second, m13, m14)
        p6.text = tp6.first
        // p7 = p4 + p5 + p6
        val tp7 = plus(tp4.second, tp5.second, tp6.second)
        p7.text = tp7.first
        // p8 = p7 + m15 + m16 + m17 + m18 + m19 + m20
        p8.text = plus(tp7.second, m15, m16, m17, m18, m19, m20).first
    }

    private fun plus(vararg arg: Float): Pair<String, Float> {
        val s = arg.joinToString("+") { it.format }
        val result = arg.reduce { acc, i -> acc + i }
        return s + "=" + result.format to result
    }

    private fun plus(p: Float, vararg arg: TextView): Pair<String, Float> {
        val newArg = arg.map { it.toFloat() }.toMutableList()
        if (p != 0f) {
            newArg.add(0, p)
        }
        val s = newArg.joinToString("+") { it.format }
        val result = newArg.reduce { acc, i -> acc + i }
        return s + "=" + result.format to result
    }

    private fun product(p: Float, vararg arg: TextView): Pair<String, Float> {
        val newArg = arg.map { it.toFloat(1) }.filter { it != 0f }.toMutableList()
        if (p != 0f) {
            newArg.add(0, p)
        }
        val s = newArg.joinToString("x") { it.format }
        val result = newArg.reduce { acc, i -> acc * i }
        return s + "=" + result.format to result
    }
}

