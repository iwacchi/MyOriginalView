package com.iwacchi.myoriginalview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var myOriginalView: MyOriginalView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myOriginalView = findViewById(R.id.myOriginalView)

    }
}
