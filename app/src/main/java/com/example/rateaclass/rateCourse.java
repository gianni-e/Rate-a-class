package com.example.rateaclass;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class rateCourse extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_course);
        Spinner course = findViewById(R.id.courseName);
        Spinner number = findViewById(R.id.courseNumber);
        number.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         /*
        check what course name is selected in the course spinner
        and display course numbers in the course spinner that correspond to it
        */
        Spinner course = findViewById(R.id.courseName);
        Spinner number = findViewById(R.id.courseNumber);
        ArrayAdapter<CharSequence> adapter = null;
        String currentSelection = (String) course.getSelectedItem();
        if (currentSelection.equals("Accounting"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.acct, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Computer Science")) {
            adapter = ArrayAdapter.createFromResource(this, R.array.cs, android.R.layout.simple_spinner_item);
        }
        number.setAdapter(adapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
