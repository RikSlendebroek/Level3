package com.example.hvaquest;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {
    private int questionNumber;
    private String[] questions;
    private TextView questionTxt;
    private Button checkBtn;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Set all view properties
        questionTxt = findViewById(R.id.questionTextview);
        checkBtn = findViewById(R.id.checkAnswerBtn);
        radioGroup = findViewById(R.id.radioGroup);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if(selectedId == -1)
                    Snackbar.make(v, getApplicationContext().getString(R.string.choose_answer), Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        questionNumber = 1;
    }

    public void populateQuestion(int questionNumber) {
        //   populate question
        String question = "question" + questionNumber;
        int holderint1 = getResources().getIdentifier(question, "string",
                this.getPackageName()); // You had used "name"
        String questionScreen = getResources().getString(holderint1);
        questionTxt.setText(questionScreen);
        // populate answer
        String answer = "answer" + questionNumber;
        int holderint = getResources().getIdentifier(answer, "array",
                this.getPackageName()); // You had used "name"
        questions = getResources().getStringArray(holderint);
        answer1.setText(items[1]);
        answer2.setText(items[2]);
        answer3.setText(items[3]);
        correctAnswer = items[0];
    }
}
