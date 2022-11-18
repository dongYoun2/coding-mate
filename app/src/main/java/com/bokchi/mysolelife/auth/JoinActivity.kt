package com.bokchi.mysolelife.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.bokchi.mysolelife.R
import com.google.firebase.auth.FirebaseAuth

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        auth = Firebase.auth


        auth.createUserWithEmailAndPassword("test@test.com", "4123")
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show()
                    }
        }

    }
}