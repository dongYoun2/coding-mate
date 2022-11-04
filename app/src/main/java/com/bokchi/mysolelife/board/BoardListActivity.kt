package com.bokchi.mysolelife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bokchi.mysolelife.databinding.ActivityMainBinding

class BoardListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val writeBtn = findViewById<Button>(R.id.writeBtn)
        writeBtn.setOnClickListener {
            
            val intent = Intent(this, BoardWriteActivity::class.java)
            startActivity(Intent)
        }
     
    }
}