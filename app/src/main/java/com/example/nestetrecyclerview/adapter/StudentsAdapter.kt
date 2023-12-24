package com.example.nestetrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nestetrecyclerview.R
import com.example.nestetrecyclerview.model.StudentsModel

class StudentsAdapter(private val sList: List<StudentsModel>): RecyclerView.Adapter<StudentsAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {

        val studentName: TextView = itemView.findViewById(R.id.studentName)
        val studentContact: TextView = itemView.findViewById(R.id.studentContact)
        val studentSubject: TextView = itemView.findViewById(R.id.studentSubject)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_list_view, parent, false))
    }

    override fun getItemCount(): Int {
        return sList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val p0 = sList[position]

        holder.studentName.text = p0.name
        holder.studentContact.text = p0.contact
        holder.studentSubject.text = p0.subject
    }
}