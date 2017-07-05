package com.example.android.basketballquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public int numQ = 0;
    //double percent = (numQ / 7) * 100;
    public EditText nameField = (EditText) findViewById(R.id.name_field);
    public String name = nameField.getText().toString();
    //creates id for correct answers
    RadioButton question1CorrectAnswer = (RadioButton) findViewById(R.id.question1_correct_answer);
    RadioButton question2CorrectAnswer = (RadioButton) findViewById(R.id.question2_correct_answer);
    RadioButton question3CorrectAnswer = (RadioButton) findViewById(R.id.question3_correct_answer);
    RadioButton question4CorrectAnswer = (RadioButton) findViewById(R.id.question4_correct_answer);
    CheckBox question5CorrectAnswer1 = (CheckBox) findViewById(R.id.question5_correct_answer1);
    CheckBox question5CorrectAnswer2 = (CheckBox) findViewById(R.id.question5_correct_answer2);
    CheckBox question5CorrectAnswer3 = (CheckBox) findViewById(R.id.question5_correct_answer3);
    CheckBox question6CorrectAnswer1 = (CheckBox) findViewById(R.id.question6_correct_answer1);
    CheckBox question6CorrectAnswer2 = (CheckBox) findViewById(R.id.question6_correct_answer2);
    RadioButton question7CorrectAnswer = (RadioButton) findViewById(R.id.question7_correct_answer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * the following method generates the score for
     *
     * @return actual score
     */

    public int generateScore() {


        //if question 1 is correct
        if (question1CorrectAnswer.isChecked()) {
            numQ = numQ++;
        }
        //if question 2 is correct
        if (question2CorrectAnswer.isChecked()) {
            numQ = numQ++;
        }
        //if question 3 is correct
        if (question3CorrectAnswer.isChecked()) {
            numQ = numQ++;
        }
        //if question 4 is correct
        if (question4CorrectAnswer.isChecked()) {
            numQ = numQ++;
        }
        //if ALL answers for question 5 are correct
        if (question5CorrectAnswer1.isChecked()) {
            if (question5CorrectAnswer2.isChecked()) {
                if (question5CorrectAnswer3.isChecked()) {
                    numQ = numQ++;
                }
            }

        }
        //if ALL answers for question 6 are correct
        if (question6CorrectAnswer1.isChecked()) {
            if (question6CorrectAnswer2.isChecked()) {
                numQ = numQ++;
            }
            //if question 7 is correct
            if (question7CorrectAnswer.isChecked()) {
                numQ = numQ++;
            }
        }

        return numQ;
    }


    /**
     * The following method creates the string message for results
     *
     * @return messageResult string
     */

    public String resultsMessage() {
        String messageResult = name + "\n" + getResources().getString(R.string.num_of_questions_correct) + generateScore() + "\n" + getResources().getString(R.string.num_of_questions_wrong) + (7 - numQ);
        //returns "Congratulations..." message for 7/7 correct
        if (numQ == 7) {
            messageResult += "\n" + getResources().getString(R.string.results_no_missed);
        }
        //returns "Well done..." message for 5/7 or 6/7 correct
        else if ((numQ <= 6) && (numQ >= 5)) {
            messageResult += "\n" + getResources().getString(R.string.results_1_to_2_missed);
        }
        //returns "Aw man..." message for 2/7 thru 4/7 correct
        else if ((numQ <= 4) && (numQ >= 2)) {
            messageResult += "\n" + getResources().getString(R.string.results_3_to_5_missed);
        }
        //returns "Do not worry..." message for 1/7 correct
        else if (numQ == 1) {
            messageResult += "\n" + getResources().getString(R.string.results_6_missed);
        }
        //returns "R.I.P..." message for 0/7 correct
        else {
            messageResult += "\n" + getResources().getString(R.string.results_all_missed);
        }

        return messageResult;
    }

    /**
     * The method below allows to display resultMessage in text view on app
     *
     * @param resultMessage1 is the message for results
     */
    public void displayMessage(String resultMessage1) {
        TextView resultsBoard = (TextView) findViewById(R.id.results_of_quiz);
        resultsBoard.setText(resultMessage1);
        //return resultMessage;
    }

    public void displayResult(View v) {
        displayMessage(resultsMessage());
    }


}
