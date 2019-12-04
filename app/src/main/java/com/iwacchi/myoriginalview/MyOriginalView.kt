package com.iwacchi.myoriginalview

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.my_original_view.view.*

// 自作Viewクラス
class MyOriginalView(context: Context,
                     attributeSet: AttributeSet) : FrameLayout(context, attributeSet) {

    init{
        // このクラスに対応するViewを設定する : my_original_view.xml
        LayoutInflater.from(context).inflate(
            R.layout.my_original_view, this, true
        )
        my_original_view_green_button.setOnClickListener { openRedButton() }
        my_original_view_red_button.setOnClickListener { openGreenButton() }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun openRedButton(){
        red_view.visibility = View.VISIBLE
        my_original_view_red_button.isClickable = false
        my_original_view_green_button.isClickable = false
        val circularReveal = ViewAnimationUtils.createCircularReveal(
            red_view,
            (my_original_view_red_button.right + my_original_view_red_button.left) / 2,
            (my_original_view_red_button.top + my_original_view_red_button.bottom) / 2,
            0f, width.toFloat()
        )
        circularReveal.duration = 500
        circularReveal.start()
        Thread(Runnable {
            Thread.sleep(500)
            my_original_view_frame_layout.setBackgroundColor(
                ContextCompat.getColor(
                    context, R.color.colorAccent
                )
            )
            my_original_view_red_button.isClickable = true
        }).start()
        green_view.visibility = View.INVISIBLE
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun openGreenButton(){
        green_view.visibility = View.VISIBLE
        my_original_view_red_button.isClickable = false
        my_original_view_green_button.isClickable = false
        val circularReveal = ViewAnimationUtils.createCircularReveal(
            green_view,
            (my_original_view_green_button.right + my_original_view_green_button.left) / 2,
            (my_original_view_green_button.top + my_original_view_green_button.bottom) / 2,
            0f, width.toFloat()
        )
        circularReveal.duration = 500
        circularReveal.start()
        Thread(Runnable {
            Thread.sleep(500)
            my_original_view_frame_layout.setBackgroundColor(
                ContextCompat.getColor(
                    context, R.color.colorPrimary
                )
            )
            my_original_view_green_button.isClickable = true
        }).start()
        red_view.visibility = View.INVISIBLE
    }

}