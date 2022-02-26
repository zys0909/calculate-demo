package com.example.calculate_zhx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
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
        onclick(m1)
    }


    fun onclick(view: View) {
        // p1 = m1 + m2
        val tp1 = m1.toFloat() + m2.toFloat()
        p1.setText(tp1.format)
        // p2 = m3 + m4 + m5
        val tp2 = m3.toFloat() + m4.toFloat() + m5.toFloat()
        p2.setText(tp2.format)
        // p3 = m6 + m7
        val tp3 = m6.toFloat() + m7.toFloat()
        p3.setText(tp3.format)
        // p4 = m8 * m9 * m10 * p1
        val tp4 = m8.toFloat(1) * m9.toFloat(1) * m10.toFloat(1) * tp1
        p4.setText(tp4.format)
        // p5 = m11 * m12 * p2
        val tp5 = m11.toFloat(1) * m12.toFloat(1) * tp2
        p5.setText(tp5.format)
        // p6 = m13 * m14 * p3
        val tp6 = m13.toFloat(1) * m14.toFloat(1) * tp3
        p6.setText(tp6.format)
        // p7 = p4 + p5 + p6
        val tp7 = tp4 + tp5 + tp6
        p7.setText(tp7.format)
        // p8 = p7 + m15 + m16 + m17 + m18 + m19 + m20
        val tp8 =
            tp7 + m15.toFloat() + m16.toFloat() + m17.toFloat() + m18.toFloat() + m19.toFloat() + m20.toFloat()
        p8.setText(tp8.format)
    }

}

