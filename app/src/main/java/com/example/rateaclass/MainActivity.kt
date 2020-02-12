package com.example.rateaclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.view.View
import android.widget.Spinner

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //access the array of strings for the spinner
        val subjects = resources.getStringArray(R.array.subjects)
        val classNamesCompSci = resources.getStringArray(R.array.classNameCompSci)
        //test comments
        //access the spinner
        val subjectSpinner = findViewById<Spinner>(R.id.subjectSpinner)
        val compSciSpinner = findViewById<Spinner>(R.id.classNamesSpinner)

        if (subjectSpinner != null)
        {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjects)
            subjectSpinner.adapter = adapter

            subjectSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long)
                {
                    //Toast.makeText(this@MainActivity, getString(R.string.selected_item) + " " + "" + subjects[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        if (compSciSpinner != null)
        {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, classNamesCompSci)
            compSciSpinner.adapter = adapter

            compSciSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
            {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long)
                {
                    //Toast.makeText(this@MainActivity, getString(R.string.selected_item) + " " + "" + classNamesCompSci[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

    }
}
