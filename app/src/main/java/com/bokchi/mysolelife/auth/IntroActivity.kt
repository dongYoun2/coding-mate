package com.bokchi.mysolelife.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bokchi.mysolelife.R

class IntroActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

    }
}