package com.example.calculate_zhx

import android.app.Activity
import android.graphics.Color
import android.graphics.Rect
import android.os.Build
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import java.math.RoundingMode
import java.text.NumberFormat

val TextView.num: Float
    get() = when {
        text.isNotEmpty() -> text.toString().toFloat()
        else -> 0f
    }
val Float.format: String
    get() = NumberFormat.getInstance().apply {
        roundingMode = RoundingMode.HALF_UP
        maximumFractionDigits = 2
        isGroupingUsed = false
    }.format(this)

fun MutableList<Float>.check(textView: TextView) {
    val num = textView.num
    if (num > 0f) {
        add(num)
    }
}

/**
 * 描述:
 *
 * author zys
 * create by 2021/2/28
 */
fun View.fitSystemBar() {
    post {
        val activity = this.context as? Activity
        activity?.fitSystemBar()
        setPadding(0, activity?.statusBarHeight ?: 0, 0, 0)
    }
}

/**
 * 透过状态栏
 */
fun Activity.fitSystemBar() {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        return
    }
    val window = this.window
    val decorView = window.decorView
    decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    // 指定状态栏的背景色
    window.statusBarColor = Color.TRANSPARENT
}

val Activity.statusBarHeight: Int
    get() {
        val result: Int
        val rect = Rect()
        this.window?.decorView?.getWindowVisibleDisplayFrame(rect)
        result = rect.top
        Log.i("测试TAG", "display: $result")
        if (result > 0) {
            return result
        }
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (resourceId > 0) {
            val offset = resources.getDimensionPixelOffset(resourceId)
            Log.i("测试TAG", "statusBar: $offset")
            offset
        } else 0
    }
