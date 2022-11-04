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
        setContentView(R.layout.activity_board_write)

        val writeBtn:Button = findViewById(R.id.writeUploadBtn)
        writeBtn.setOnClickListener {

            val writeText = findViewById<EditText>(R.id.writeTextArea)

            val database = Firebase.database
            val myRef = database.getReference("board")

            myRef.push().setValue(
                Model(writeText.text.toString())
            )
        }
     
    }
}