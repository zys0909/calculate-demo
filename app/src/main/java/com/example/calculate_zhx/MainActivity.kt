package com.example.calculate_zhx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

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
    private val tvResult: TextView by lazy { findViewById(R.id.tv_result) }

    private val p1: EditText by lazy { findViewById(R.id.p1) }
    private val p2: EditText by lazy { findViewById(R.id.p2) }
    private val p3: EditText by lazy { findViewById(R.id.p3) }
    private val p4: EditText by lazy { findViewById(R.id.p4) }
    private val p5: EditText by lazy { findViewById(R.id.p5) }
    private val p6: EditText by lazy { findViewById(R.id.p6) }
    private val p7: EditText by lazy { findViewById(R.id.p7) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onclick(view: View) {
        val mList = mutableListOf<Float>()
        mList.check(m1)
        mList.check(m2)
        mList.check(m3)
        mList.check(m4)
        mList.check(m5)
        mList.check(m6)
        mList.check(m7)
        mList.check(m8)

        val pList = mutableListOf<Float>()
        pList.check(p1)
        pList.check(p2)
        pList.check(p3)
        pList.check(p4)
        pList.check(p5)
        pList.check(p6)
        pList.check(p7)
        val sb = StringBuilder()
        var mr: Float = 1f
        mList.forEachIndexed { index, it ->
            sb.append(it.format)
            if (index < mList.size - 1) {
                sb.append("×")
            }
            mr *= it
        }
        var pr = 0f
        pList.forEach {
            sb.append("＋").append(it.format)
            pr += it;
        }
        if (sb.isNotEmpty()) {
            sb.append("＝").append(mr + pr);
            tvResult.text = sb.toString()
        }
    }

}

