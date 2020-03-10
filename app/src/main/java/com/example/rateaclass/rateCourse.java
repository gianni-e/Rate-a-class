package com.example.rateaclass;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class rateCourse extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    String ServerURL = "http://127.0.0.1/api/getdata.php";
    //Data input from users
    EditText professor, comments;
    Spinner courseName, courseNumber;
    RatingBar rating;
    //variables to use for inserting to SQL
    String course_name, professor_name, comments_given, course_number, rating_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_course);
        courseSelection();
        comments = findViewById(R.id.comments);
        professor = findViewById(R.id.professorName);
        courseNumber = findViewById(R.id.courseNumber);
        courseName = findViewById(R.id.courseName);
        rating = findViewById(R.id.ratingBar);
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ratingValue = String.valueOf(rating.getNumStars());
                final String nameValue = courseName.getSelectedItem().toString().trim();
                final String numberValue = courseNumber.getSelectedItem().toString().trim();
                final String commentsValue = comments.getText().toString().trim();
                final String professorValue = professor.getText().toString().trim();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, ServerURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                    }
                }, new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String,String> params = new HashMap<>();
                        params.put("rating", ratingValue);
                        params.put("name", nameValue);
                        params.put("number", numberValue);
                        params.put("comments", commentsValue);
                        params.put("professor", professorValue);
                        return params;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
                Log.d("TAG", "onClick: Success!");
            }
        });
    }

    public void getData()
    {
        course_name = String.valueOf(courseName.getSelectedItem());
        professor_name = professor.getText().toString();
        comments_given = comments.getText().toString();
        course_number = String.valueOf(courseNumber.getSelectedItem());
        rating_value = String.valueOf(rating.getRating());
    }

    public Boolean isEmpty(String strValue) {
        if (strValue == null || strValue.trim().equals(("")))
            return true;
        else
            return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        courseSelection();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void courseSelection()
    {
        Spinner course = findViewById(R.id.courseName);
        Spinner number = findViewById(R.id.courseNumber);
         /*
        check what course name is selected in the course spinner
        and display course numbers in the course spinner that correspond to it
        */
        ArrayAdapter<CharSequence> adapter = null;
        String currentSelection = (String) course.getSelectedItem();
        if (currentSelection.equals("Accounting"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.acct, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Computer Science"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.cs, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Art") || currentSelection.equals("Art Education"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.art, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Astronomy"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.astr, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Biology"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.bio, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Business Administration"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.busa, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Chemistry"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.chem, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Communication Arts"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.ca, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Criminal Justice"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.cj, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Economics"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.econ, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.contains("Education"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.ed, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("English"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.eng, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Finance"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.fin, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Forensic Science"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.fs, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("French"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.fr, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Geography"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.geog, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("History"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.hist, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Italian"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.ital, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Kinesiology"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.kin, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Management"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.mgt, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Marketing"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.mkt, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Mathematics"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.math, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Music"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.mus, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Philosophy"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.phil, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Physics"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.phy, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Political Science"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.pols, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Psychology"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.psyc, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Religious Studies"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.rels, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Science"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.sci, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Sociology"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.soc, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Spanish"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.span, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Writing"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.writing, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Sports Management Studies"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.spm, android.R.layout.simple_spinner_item);
        }
        else if(currentSelection.equals("Hospitality Management"))
        {
            adapter = ArrayAdapter.createFromResource(this, R.array.hosp, android.R.layout.simple_spinner_item);
        }


        number.setAdapter(adapter);
        number.setOnItemSelectedListener(this);
    }

}
