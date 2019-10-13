package com.example.ass7sec1dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.female
import kotlinx.android.synthetic.main.add_dialog_layout.view.male

class MainActivity : AppCompatActivity() {
    val employeeList = arrayListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testEmployeeData()
        recycler_view.adapter = EmployeeAdapter(this.employeeList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext) as RecyclerView.LayoutManager?
        recycler_view.itemAnimator = DefaultItemAnimator()
    }

    fun addEmployee(v: View){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)

        val mAlertDialog = mBuilder.show()






        mDialogView.btnAdd.setOnClickListener{
            var RadioGroup :Int = mDialogView.radioGroup.checkedRadioButtonId
            var radioButton :RadioButton = mDialogView.findViewById(RadioGroup)



            employeeList.add(Employee(mDialogView.edt_name.text.toString(),radioButton.text.toString(),mDialogView.edt_email.text.toString(),
                mDialogView.edt_salary.text.toString().toInt()))
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext,"the Employee is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }

        mDialogView.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }

    fun testEmployeeData(){
        employeeList.add(Employee("care","Female", "care@gmail.com", 23000))
        employeeList.add(Employee("Frame","Male", "frame@gmail.com", 45000))
    }
}
