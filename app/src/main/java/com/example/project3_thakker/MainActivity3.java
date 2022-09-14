/**
*Third activity for showing the correct answers and for returning to the home page to start over
*@author Devin Thakker
 */
package com.example.project3_thakker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    //View item variables created

    TextView correctAnswers;

    Button home;

    /**
     * onCreate for the activity_main3
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Set view to variables

        correctAnswers = findViewById(R.id.correctAnswers);
        home = findViewById(R.id.returnHome);

        //get intent for data
        int correct = getIntent().getIntExtra("correctAnswers",0);

        //Correct answers
        correctAnswers.setText("Total number of questions solved correctly - " + String.valueOf(correct));

        //onClick listener for going back to the home screen
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}