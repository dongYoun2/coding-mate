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

        val category = intent.getStringExtra("category")


        if(category == "category1") {

            myRef = database.getReference("contents")

        } else if(category == "category2") {

            myRef = database.getReference("contents2")
            
        }

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (dataModel in dataSnapshot.children) {
                    Log.d("ContentListActivity", dataModel.toString())
                    val item = dataModel.getValue(ContentModel::class.java)
                    items.add(item!!)

                }
                rvAdapter.notifyDataSetChanged()
                Log.d("ContentListActivity", items.toString())

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)

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