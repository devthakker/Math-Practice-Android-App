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

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity{

    //Creating variables for views

    Button submit;

    TextView numOne,numTwo,oper;

    EditText answer;

    //All data variables that are needed created bellow

    ArrayList<Double> answers = new ArrayList<Double>();

    int correctAnswers = 0;
    int questionIndex = 0;

    /**
     * onCreate for the activity_main2
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //get intent block for data
        ArrayList<Integer> firstNum = getIntent().getIntegerArrayListExtra("firstNum");
        ArrayList<Integer> secondNum = getIntent().getIntegerArrayListExtra("secondNum");

        int questions = getIntent().getIntExtra("questions", firstNum.size());

        String operator = getIntent().getStringExtra("oper");

        //Setting all variables equal to the view IDs

        numOne = findViewById(R.id.questionNumOne);
        numTwo = findViewById(R.id.questionNumTwo);

        oper = findViewById(R.id.operator);

        submit = findViewById(R.id.Submit);

        answer = findViewById(R.id.answerEditText);

        //Set base text
        numOne.setText(String.valueOf(firstNum.get(questionIndex)));
        numTwo.setText(String.valueOf(secondNum.get(questionIndex)));

        oper.setText(operator);

        //Onclick listener for the done button which check for correctness with the function
        // along with checking if an answer was answered
        // Also goes to final activity if all questions have been answered
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    try {
                        answers.add(Double.valueOf(answer.getText().toString()));
                        checkAnswer(questionIndex, operator, firstNum, secondNum);
                        answer.getText().clear();
                        questionIndex++;
                        numOne.setText(String.valueOf(firstNum.get(questionIndex)));
                        numTwo.setText(String.valueOf(secondNum.get(questionIndex)));
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Enter answer", Toast.LENGTH_LONG).show();
                    }
                    if (questionIndex == questions){
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        intent.putExtra("correctAnswers",correctAnswers);
                        startActivity(intent);
                    }

                }
            });
    }


    /**
     * Method to check answer of the input from the user and storing if it was correct
     * @param number
     */
    public void checkAnswer(int number, String operator, ArrayList<Integer> firstNum, ArrayList<Integer> secondNum){
        if(operator.trim().equals("/")){
            if (Double.compare(answers.get(number),Double.valueOf(firstNum.get(number)/secondNum.get(number)))==0){
                correctAnswers++;
            }
        }if(operator.trim().equals("x")){
            if (Double.compare(answers.get(number),Double.valueOf(firstNum.get(number)*secondNum.get(number)))==0){
                correctAnswers++;
            }
        }if(operator.trim().equals("+")){
            if (Double.compare(answers.get(number),Double.valueOf(firstNum.get(number)+secondNum.get(number))) == 0){
                correctAnswers++;
            }
        }if(operator.trim().equals("-")){
            if (Double.compare(answers.get(number),Double.valueOf(firstNum.get(number)-secondNum.get(number)))==0){
                correctAnswers++;
            }
        }
    }
}