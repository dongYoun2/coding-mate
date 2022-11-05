package com.bokchi.mysolelife.board

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import com.bokchi.mysolelife.R

class ListViewAdapter(val boardList : MutableList<Model>) : BaseAdapter() {

    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItem(position: Int): Any {
        return boardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

       if (view == null) {

        view = LayoutInflater.from(parent?.context).inflate(R.layout.board_list_item, parent, false)

       }
       
       val title = view?.findViewById<TextView>(R.id.itemTextId)
       title!!.text = List[position].title

        return view!!
    }
}