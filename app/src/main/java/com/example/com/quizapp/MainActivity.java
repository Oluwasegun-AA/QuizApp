package com.example.com.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.quizapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** this section gets the click feedback from the checkbox and radial button
     * bearing the answers
     * i.e Question one answer is under button ID: Question_Answer1
     *      Question two answer is under button ID: Question_Answer2
     *      ''
     *      ''
     *      ''
     *      ''
     *      ''
     *      Question ten answer is under button ID: Question_Answer10*/

    public void correct(View view) {
        int score = 0;
        String wrong = "";
        String wrong_answers = "";
        RadioButton ans1 = findViewById(R.id.Question_Answer1);
        Boolean isans1 = ans1.isChecked();
        if (isans1) {
            score += 1;
        } else wrong += " 1,";

        RadioButton ans2 = findViewById(R.id.Question_Answer2);
        Boolean isans2 = ans2.isChecked();
        if (isans2) {
            score += 1;
        } else wrong += " 2,";

        /** this section gets the answers fron a Checkbox field
         * Checkboxs are used for questions with multiple answers */
        CheckBox ans3a = findViewById(R.id.Question_Answer3a);
        CheckBox ans3c = findViewById(R.id.Question_Answer3c);
        CheckBox ans3d = findViewById(R.id.Question_Answer3d);
        Boolean isans3a = ans3a.isChecked();
        Boolean isans3c = ans3c.isChecked();
        Boolean isans3d = ans3d.isChecked();
        if (isans3a && isans3c && isans3d) {
            score += 1;
        } else wrong += " 3,";

        RadioButton ans4 = findViewById(R.id.Question_Answer4);
        Boolean isans4 = ans4.isChecked();
        if (isans4) {
            score += 1;
        } else wrong += " 4,";

        RadioButton ans5 = findViewById(R.id.Question_Answer5);
        Boolean isans5 = ans5.isChecked();
        if (isans5) {
            score += 1;
        } else wrong += " 5,";

        RadioButton ans7 = findViewById(R.id.Question_Answer7);
        Boolean isans7 = ans7.isChecked();
        if (isans7) {
            score += 1;
        } else wrong += " 7,";

        /**  this section gets user input through the text field*/
        EditText response = findViewById(R.id.Question_Answer6);
        String nigeria = response.getText().toString();

        switch (nigeria)
        {
            case "Nigeria":
                score += 1;
                break;
            default :
                wrong += " 6,";

        }


        RadioButton ans8 = findViewById(R.id.Question_Answer8);
        Boolean isans8 = ans8.isChecked();
        if (isans8) {
            score += 1;
        } else wrong += " 8,";

        RadioButton ans9 = findViewById(R.id.Question_Answer9);
        Boolean isans9 = ans9.isChecked();
        if (isans9) {
            score += 1;
        } else wrong += " 9,";

        RadioButton ans10 = findViewById(R.id.Question_Answer10);
        Boolean isans10 = ans10.isChecked();
        if (isans10) {
            score += 1;
        } else wrong += " 10,";
        Toast.makeText(this, "your Score is " + score, Toast.LENGTH_SHORT).show();

        String result_text = getString(R.string.result_statement);
        result_text += getString(R.string.result_score);
        result_text += " " + score + "/10\n\n";
        if (score < 10)
        {
            wrong_answers = getString(R.string.result_wrong_answer) + "\n";
            wrong_answers += " " + wrong + ".";
        }else wrong_answers = "";

        display_result(result_text, wrong_answers);
    }
    /** This section formats the textview to display the results */
    public void display_result(String result_text, String wrong) {
        TextView display_result = (TextView) findViewById(R.id.result);
        display_result.setText("" + result_text + wrong);
    }

}
