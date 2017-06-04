package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correctAnswers = 0, totalQuestions = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitAnswers(View view) {
        //Check each answer and display the total
        boolean resultOne = checkAnswerOne();
        Log.v("MainActivity", "1: " + resultOne);

        checkAnswerTwo();

        boolean resultThree = checkAnswerThree();
        Log.v("MainActivity", "3: " + resultThree);

        boolean resultFour = checkAnswerFour();
        Log.v("MainActivity", "4: " + resultFour);

        boolean resultFive = checkAnswerFive();
        Log.v("MainActivity", "5: " + resultFive);

        if (resultOne && resultThree && resultFour && resultFive) {
            Toast.makeText(this, "You got " + correctAnswers + " out of " + totalQuestions + " correct!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Must answer all questions before submitting", Toast.LENGTH_LONG).show();
        }

        correctAnswers = 0;
    }

    public boolean checkAnswerOne() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_1_radiogroup);

        if (rg.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            if (rg.getCheckedRadioButtonId() == R.id.question_one_answer) {
                correctAnswers++;
            }
            return true;
        }
    }

    public void checkAnswerTwo() {
        CheckBox cbA = (CheckBox) findViewById(R.id.question_two_A);
        CheckBox cbB = (CheckBox) findViewById(R.id.question_two_B);
        CheckBox cbC = (CheckBox) findViewById(R.id.question_two_C);
        CheckBox cbD = (CheckBox) findViewById(R.id.question_two_D);

        if (cbA.isChecked() && !cbB.isChecked() && cbC.isChecked() && !cbD.isChecked()) {
            correctAnswers++;
        }
    }

    public boolean checkAnswerThree() {
        EditText ET = (EditText) findViewById(R.id.question_3_edittext);
        String answer = "Jeff Kaplan";
        String enteredAnswer = ET.getText().toString();

        if (enteredAnswer.isEmpty()) {
            return false;
        } else {
            if (enteredAnswer.trim().toLowerCase().equals(answer.toLowerCase())) {
                correctAnswers++;
            }
            return true;
        }
    }

    public boolean checkAnswerFour() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_4_radiogroup);

        if (rg.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            if (rg.getCheckedRadioButtonId() == R.id.question_four_answer) {
                correctAnswers++;
            }
            return true;
        }
    }

    public boolean checkAnswerFive() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.question_5_radiogroup);

        if (rg.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            if (rg.getCheckedRadioButtonId() == R.id.question_five_answer) {
                correctAnswers++;
            }
            return true;
        }
    }
}
