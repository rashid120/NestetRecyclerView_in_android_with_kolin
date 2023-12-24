package com.example.nestetrecyclerview.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.nestetrecyclerview.R
import com.example.nestetrecyclerview.interfaces.AddNewStudent
import com.example.nestetrecyclerview.model.StudentsModel
import com.example.nestetrecyclerview.model.TeachersModel

class TeacherAdapter(val cxt: Context, private val tList: List<TeachersModel>, val onclick: AddNewStudent): RecyclerView.Adapter<TeacherAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val moreVert: ImageView = itemView.findViewById(R.id.more_vertImg)

        val teacherName: TextView = itemView.findViewById(R.id.teacherName)
        val teacherContact: TextView = itemView.findViewById(R.id.teacherContact)

        val studentsRecyclerView: RecyclerView = itemView.findViewById(R.id.studentRecycler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.teacher_list_view, parent, false))
    }

    override fun getItemCount(): Int {
        return tList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val p0 = tList[position]

        holder.teacherName.text = p0.name
        holder.teacherContact.text = p0.contact

        val sListSize = p0.students?.size!!
        val studentArray = arrayListOf<StudentsModel>()

        for (i in 0 until sListSize) {

            if (p0.id == p0.students[i].tId) { // teacher id (1) == student Tid (1) , 2 == 2

                studentArray.add(p0.students[i])
            }
            if (p0.id == 1){

                studentArray.addAll(p0.students)
                break
            }
        }
        val adapter = StudentsAdapter(studentArray)
        holder.studentsRecyclerView.adapter = adapter

        holder.moreVert.setOnClickListener {

            onclick.addStudent(p0.id!!, sListSize + 2)
        }
    }
}