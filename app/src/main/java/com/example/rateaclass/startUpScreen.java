package com.example.rateaclass;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startUpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_screen);
        Button rateButton = (Button) findViewById(R.id.rateCourse);
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRateCourse();
            }
        });
    }

    public void openRateCourse()
    {
        Intent intent = new Intent(this, rateCourse.class);
        startActivity(intent);
    }
}


