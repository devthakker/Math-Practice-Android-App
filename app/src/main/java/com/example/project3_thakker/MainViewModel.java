/**
ViewModel class to store all data necessary through the all activities in this app
@author Devin Thakker
 */
package com.example.project3_thakker;


//imported classes
import android.util.Log;

import androidx.lifecycle.ViewModel;

import org.xml.sax.helpers.AttributesImpl;

import java.util.ArrayList;


//ViewModel class thats extended by my Main version of it to store my data
public class MainViewModel extends ViewModel {

    //All data variables that are needed created bellow

    public static ArrayList<Integer> firstNum = new ArrayList<Integer>();
    public static ArrayList<Integer> secondNum = new ArrayList<Integer>();
    public static ArrayList<Double> answer = new ArrayList<Double>();

    public static int questionIndex = 0;

    public static String oper;

    public static int questions = 10;

    public static int correctAnswers = 0;

    public static int maxNumber;


    //Unused constructor
    public MainViewModel() {

    }


    public static ArrayList<Integer> getFirstNum() {
        return firstNum;
    }

    public static void setFirstNum(ArrayList<Integer> firstNum) {
        MainViewModel.firstNum = firstNum;
    }

    public static ArrayList<Integer> getSecondNum() {
        return secondNum;
    }

    public static void setSecondNum(ArrayList<Integer> secondNum) {
        MainViewModel.secondNum = secondNum;
    }

    public static ArrayList<Double> getAnswer() {
        return answer;
    }

    public static void setAnswer(ArrayList<Double> answer) {
        MainViewModel.answer = answer;
    }

    public static int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    public static String getOper() {
        return oper;
    }

    public static void setOper(String oper) {
        MainViewModel.oper = oper;
    }

    public static int getQuestions() {
        return questions;
    }

    public static void setQuestions(int questions) {
        MainViewModel.questions = questions;
    }

    public static int getCorrectAnswers() {
        return correctAnswers;
    }

    public static void setCorrectAnswers(int correctAnswers) {
        MainViewModel.correctAnswers = correctAnswers;
    }

    public static int getMaxNumber() {
        return maxNumber;
    }

    public static void setMaxNumber(int maxNumber) {
        MainViewModel.maxNumber = maxNumber;
    }
}
