package com.kotlin.siddhant.kotlin_handledata

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class HandleDataActivity : AppCompatActivity() {

    var etName: EditText? =null
    var etMiddleName:EditText?=null
    var etLastName:EditText?=null
    var btnSubmit: Button?=null
    var tvName:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle_data)
        etName=findViewById(R.id.etName)
        etMiddleName=findViewById(R.id.etMiddleName)
        etLastName=findViewById(R.id.etLastName)
        btnSubmit=findViewById(R.id.btnSubmit)
        tvName=findViewById(R.id.tvName)
        btnSubmit?.setOnClickListener {
            setName(""+etName?.text.toString()+" "+etMiddleName?.text.toString()+" "+etLastName?.text.toString())
        }



    }
    public fun setName(name:String)
    {
        tvName?.setText(""+name)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"Destroy Method Called",Toast.LENGTH_LONG).show()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Toast.makeText(this,"onRestoreInstanceState Method Called",Toast.LENGTH_LONG).show()
       // setName(savedInstanceState?.getString("name","").toString())

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Toast.makeText(this,"onSaveInstanceState Method Called",Toast.LENGTH_LONG).show()
        outState?.putString("name",""+etName?.text.toString()+" "+etMiddleName?.text.toString()+" "+etLastName?.text.toString())

    }
}
