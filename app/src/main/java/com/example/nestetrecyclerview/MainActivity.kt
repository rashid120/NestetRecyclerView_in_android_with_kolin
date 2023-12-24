package com.example.nestetrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.nestetrecyclerview.adapter.TeacherAdapter
import com.example.nestetrecyclerview.interfaces.AddNewStudent
import com.example.nestetrecyclerview.model.StudentsModel
import com.example.nestetrecyclerview.model.TeachersModel

class MainActivity : AppCompatActivity(), AddNewStudent {

    // replace with SQLite
    private lateinit var teacherArray: ArrayList<TeachersModel>
    private lateinit var studentsArray: ArrayList<StudentsModel>
    private lateinit var adapter: TeacherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.firstRecycler)

        studentsArray = arrayListOf()
        teacherArray = arrayListOf()

        studentsArray.add(StudentsModel(1, "Zahid Khan", "9374729473","Android",5))
        studentsArray.add(StudentsModel(2, "Ahmad Raza", "5486232378","Android",2))
        studentsArray.add(StudentsModel(3, "Azim Raza", "7298472387","Android",2))
        studentsArray.add(StudentsModel(4, "Rohit Kumar", "8732472732","Android",3))
        studentsArray.add(StudentsModel(5, "Naushad Alam", "8732472732","Android",4))
        studentsArray.add(StudentsModel(6, "Bipul Alam", "8732472732","Android",5))

        teacherArray.add(TeachersModel(1,"Rahul Raj","4985793747","Android, Flutter, PHP", studentsArray))
        teacherArray.add(TeachersModel(2,"Ansar Ali","9931032833","Flutter", studentsArray))
        teacherArray.add(TeachersModel(3,"Sudish Ali","45376534734","Android", studentsArray))
        teacherArray.add(TeachersModel(4,"Amaranth Ali","6384732234","PHP, SQL", studentsArray))
        teacherArray.add(TeachersModel(5,"Rashid Khan","8478824808","Flutter", studentsArray))

        adapter = TeacherAdapter(this, teacherArray, this)
        recyclerView.adapter = adapter
    }

    override fun addStudent(tId: Int, newSId: Int) {

        val dialog = AlertDialog.Builder(this)
        
        val layout = LayoutInflater.from(this).inflate(R.layout.add_student_dialog, null, false)

        val name: EditText = layout.findViewById(R.id.newSName)
        val contact: EditText = layout.findViewById(R.id.newSContact)
        val subject: EditText = layout.findViewById(R.id.newSSubject)
        val addBtn: AppCompatButton = layout.findViewById(R.id.addSBtn)

        dialog.setView(layout)

        val create = dialog.create()

        addBtn.setOnClickListener {

            if (name.text.isEmpty() || contact.text.isEmpty() || subject.text.isEmpty()){

                return@setOnClickListener
            }else{

                studentsArray.add(StudentsModel(newSId,name.text.toString(), contact.text.toString(), subject.text.toString(), tId))
                adapter.notifyDataSetChanged()
                create.dismiss()
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
            }
        }

        create.show()
    }
}