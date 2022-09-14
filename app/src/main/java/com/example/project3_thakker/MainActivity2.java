/**
 * Second activity for showing the questions with and enter button with text field
 * @author Devin Thakker
 */
package com.example.project3_thakker;

//imports
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.fonts.SystemFonts;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity2 extends AppCompatActivity{

    //Creating variables for views

    Button submit;

    TextView numOne,numTwo,oper;

    EditText answer;

    /**
     * onCreate for the activity_main2
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Setting all variables equal to the view IDs

        numOne = findViewById(R.id.questionNumOne);
        numTwo = findViewById(R.id.questionNumTwo);

        oper = findViewById(R.id.operator);

        submit = findViewById(R.id.Submit);

        answer = findViewById(R.id.answerEditText);

        //Set base text
        numOne.setText(String.valueOf(MainViewModel.firstNum.get(MainViewModel.questionIndex)));
        numTwo.setText(String.valueOf(MainViewModel.secondNum.get(MainViewModel.questionIndex)));

        oper.setText(MainViewModel.oper);

        //Onclick listener for the done button which check for correctness with the function
        // along with checking if an answer was answered
        // Also goes to final activity if all questions have been answered
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try {
                        MainViewModel.answer.add(Double.valueOf(answer.getText().toString()));
                        checkAnswer(MainViewModel.questionIndex);
                        answer.getText().clear();
                        MainViewModel.questionIndex++;
                        numOne.setText(String.valueOf(MainViewModel.firstNum.get(MainViewModel.questionIndex)));
                        numTwo.setText(String.valueOf(MainViewModel.secondNum.get(MainViewModel.questionIndex)));
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Enter answer", Toast.LENGTH_LONG).show();
                    }
                    if (MainViewModel.questionIndex == MainViewModel.questions){
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        startActivity(intent);
                    }

                }
            });
    }


    /**
     * Method to check answer of the input from the user and storing if it was correct
     * @param number
     */
    public void checkAnswer(int number){
        if(MainViewModel.oper.trim().equals("/")){
            if (Double.compare(MainViewModel.answer.get(number),Double.valueOf(MainViewModel.firstNum.get(number)/MainViewModel.secondNum.get(number)))==0){
                MainViewModel.correctAnswers++;
            }
        }if(MainViewModel.oper.trim().equals("x")){
            if (Double.compare(MainViewModel.answer.get(number),Double.valueOf(MainViewModel.firstNum.get(number)*MainViewModel.secondNum.get(number)))==0){
                MainViewModel.correctAnswers++;
            }
        }if(MainViewModel.oper.trim().equals("+")){
            if (Double.compare(Double.valueOf(MainViewModel.answer.get(number)),Double.valueOf(MainViewModel.firstNum.get(number)+MainViewModel.secondNum.get(number))) == 0){
                MainViewModel.correctAnswers++;
            }
        }if(MainViewModel.oper.trim().equals("-")){
            if (Double.compare(MainViewModel.answer.get(number),Double.valueOf(MainViewModel.firstNum.get(number)-MainViewModel.secondNum.get(number)))==0){
                MainViewModel.correctAnswers++;
            }
        }
    }
}