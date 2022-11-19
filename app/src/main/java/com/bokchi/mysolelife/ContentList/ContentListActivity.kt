package com.bokchi.mysolelife.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bokchi.mysolelife.R


class ContentListActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_content_list)

        val rv: RecyclerView = findViewById(R.id.rv)

        val items = ArrayList<ContentModel>()
        items.add(ContentModel("imageUrl1", "title1"))
        items.add(ContentModel("imageUrl2", "title2"))
        items.add(ContentModel("imageUrl3", "title3"))

        val rvAdapter = ContentRVAdapter(items)
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(this, 2)
     }
}