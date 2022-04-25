package com.cwise.teacherappkotlin.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cwise.teacherappkotlin.R

class ShowRecAdapter(val datum: MutableList<Datum>) : RecyclerView.Adapter<RecViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.child_rec_layout, parent, false)
        return RecViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        return holder.bindView(datum[position])
    }

    override fun getItemCount(): Int {
        return datum.size
    }
}

class RecViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvName: TextView = itemView.findViewById(R.id.child_name)
    private val tvAttendence: TextView = itemView.findViewById(R.id.child_attendance)
    private val phoneNo: TextView = itemView.findViewById(R.id.phone_no)
    fun bindView(datum: Datum) {
        tvName.text = datum.childsName
        tvAttendence.text = datum.childsAttendance
        phoneNo.text = datum.phoneNo
    }
}