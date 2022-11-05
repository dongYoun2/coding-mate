package com.bokchi.mysolelife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bokchi.mysolelife.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot

class BoardListActivity : AppCompatActivity() {

    lateint var LVAdapter: ListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val writeBtn = findViewById<Button>(R.id.writeBtn)
        writeBtn.setOnClickListener {
            
            val intent = Intent(this, BoardWriteActivity::class.java)
            startActivity(Intent)
        }

        val list = MutableListOf<Model>()
        list.add(Model("a"))
        list.add(Model("b"))
        list.add(Model("c"))

        LVAdapter = ListViewAdapter()

        val lv = findViewById<ListView>(R.id.lv)

        lv.adapter = LVAdapter

        getData()
    }

    fun getData() {

        val database = Firebase.database
        val myRef = database.getReference("board")


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
               Log.d("BoardListActivity", dataSnapshot.toString())
                // ..
                for (dataModel in dataSnapshot.children) {
                    val item = dataModel.getValue(Model::class.java)
                    Log.d("BoardListActivity", item.toString())
                }
            }

            @Override
            public void onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("BoardListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener);

    }
}