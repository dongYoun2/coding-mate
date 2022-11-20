package com.bokchi.mysolelife.contentsList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bokchi.mysolelife.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ContentListActivity : AppCompatActivity() {

    lateinit var myRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_content_list)

         val items = ArrayList<ContentModel>()
         val rvAdapter = ContentRVAdapter(baseContext, items)

         // Write a message to the database
         val database = Firebase.database
         val myRef = database.getReference("contents")

         myRef.push().setValue(
            ContentModel("title1", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FblYPPY%2Fbtq66v0S4wu%2FRmuhpkXUO4FOcrlOmVG4G1%2Fimg.png", "https://philosopher-chan.tistory.com/1235?category=941578")
         )
         myRef.push().setValue(
            ContentModel("title2", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FznKK4%2Fbtq665AUWem%2FRUawPn5Wwb4cQ8BetEwN40%2Fimg.png", "https://philosopher-chan.tistory.com/1235?category=941578")
         )
         myRef.push().setValue(
            ContentModel("title3", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbtig9C%2Fbtq65UGxyWI%2FPRBIGUKJ4rjMkI7KTGrxtK%2Fimg.png", "https://philosopher-chan.tistory.com/1235?category=941578")
         )
         myRef.push().setValue(
            ContentModel("title2", "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FznKK4%2Fbtq665AUWem%2FRUawPn5Wwb4cQ8BetEwN40%2Fimg.png", "https://philosopher-chan.tistory.com/1235?category=941578")
         )

         val rv : RecyclerView = findViewById(R.id.rv)

         rv.adapter = rvAdapter

         rv.layoutManager = GridLayoutManager(this, 2)

         rvAdapter.itemClick = object : ContentRVAdapter.ItemClick {
               override fun onClick(view: View, position: Int) {

                  Toast.makeText(baseContext, items[position].title, Toast.LENGTH_LONG).show()

                  val intent = Intent(this@ContentListActivity, ContentShowActivity::class.java)
                  intent.putExtra("url", items[position].webUrl)
                  startActivity(intent)
               }

         }
    }
}
