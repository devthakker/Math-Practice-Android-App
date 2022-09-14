/**
 * First activity for asking user for difficulty of questions, operation to use, and how many questions they would like.
 * @author Devin Thakker
 */
package com.example.project3_thakker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //View item variables created

    Button minusQuestion, plusQuestion, start;

    RadioGroup difficulty, operation;

    RadioButton easy, medium, hard, add, sub, mult, div;

    TextView numberQuestions;

    //All data variables that are needed created bellow

    ArrayList<Integer> firstNum = new ArrayList<Integer>();
    ArrayList<Integer> secondNum = new ArrayList<Integer>();

    int questions = 10;

    int maxNumber;

    String oper;



    /**
     * onCreate for the activity_main1
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        difficulty = findViewById(R.id.difficulty);

        easy = findViewById(R.id.easy);
        medium = findViewById(R.id.medium);
        hard = findViewById(R.id.hard);

        operation = findViewById(R.id.operation);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);

        numberQuestions = findViewById(R.id.numberQuestions);

        minusQuestion = findViewById(R.id.minusQuestions);
        plusQuestion = findViewById(R.id.plusQuestions);

        start = findViewById(R.id.start);

        start.setOnClickListener(this);

    }

    /**
     * onClick for checking all buttons that were clicked and storing all data along with
     * generating numbers needed for all questions
     * Goes to next activity when button is clicked
     * @param view
     */
    public void onClick(View view){
        int operationCheckedId = operation.getCheckedRadioButtonId();
        int difficultyCheckedId = difficulty.getCheckedRadioButtonId();

        if(operationCheckedId == R.id.add){
            oper = "+";
        }else if(operationCheckedId == R.id.sub){
            oper = "-";
        }else if(operationCheckedId == R.id.mult){
            oper = "x";
        }else if(operationCheckedId == R.id.div){
            oper = "/";
        }

        if(difficultyCheckedId == R.id.easy){
            maxNumber = 10;
        }else if(difficultyCheckedId == R.id.medium){
            maxNumber = 25;
        }else if(difficultyCheckedId == R.id.hard){
            maxNumber = 50;
        }

        generateRandomNum();

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("questions", questions);
        intent.putExtra("oper", oper);
        intent.putIntegerArrayListExtra("firstNum", firstNum);
        intent.putIntegerArrayListExtra("secondNum", secondNum);
        startActivity(intent);

        Log.v(null,String.valueOf(maxNumber));
        Log.v(null,oper);
        Log.v(null,firstNum.toString());
        Log.v(null,secondNum.toString());

    }

    /**
     * Method for generating random numbers used
     */
    private void generateRandomNum() {
        Random rand = new Random();

        firstNum.clear();
        secondNum.clear();

        for (int i = 0; i < questions; i++) {
            firstNum.add(rand.nextInt(maxNumber));
        }
        for (int j = 0; j < questions; j++) {
            secondNum.add(rand.nextInt(maxNumber));
        }
    }

    /**
     *  method to increase the number of questions when the minus button is clicked
     */
    public void addQ(View view){
        questions++;
        numberQuestions.setText(String.valueOf(questions));
        Log.v(null,"Number of questions " + String.valueOf(questions));
    }

    /**
     * method to decrease the number of questions when the minus button is clicked
     * @param view
     */
    public void subQ(View view){
        if(questions == 1){
            Toast.makeText(getApplicationContext(), "1 is the minimum", Toast.LENGTH_SHORT).show();
        }else{
            questions--;
            numberQuestions.setText(String.valueOf(questions));
            Log.v(null,"Number of questions " + String.valueOf(questions));
        }
    }
}