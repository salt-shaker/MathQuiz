package com.e.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_go, btn_answer1, btn_answer2, btn_answer3, btn_answer4;
    TextView tv_questions, tv_score, tv_timer;
    ProgressBar pb_progressBar;
    int countDown = 60;
    Question q = new Question();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_go = findViewById(R.id.btn_go);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);
        btn_answer4 = findViewById(R.id.btn_answer4);

        final Button[] buttons = new Button[4];
        buttons[0] = btn_answer1;
        buttons[1] = btn_answer2;
        buttons[2] = btn_answer3;
        buttons[3] = btn_answer4;

        btn_answer1.setEnabled(false);
        btn_answer2.setEnabled(false);
        btn_answer3.setEnabled(false);
        btn_answer4.setEnabled(false);

        tv_questions = findViewById(R.id.tv_questions);
        tv_score = findViewById(R.id.tv_score);
        tv_timer = findViewById(R.id.tv_timer);

        pb_progressBar = findViewById(R.id.pb_progressBar);

        // playGame

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_go.setVisibility(View.GONE);
                btn_answer1.setEnabled(false);
                timer.start();
                q.makeQuestion(tv_questions, buttons);
                btn_answer1.setEnabled(true);
                btn_answer2.setEnabled(true);
                btn_answer3.setEnabled(true);
                btn_answer4.setEnabled(true);
            }
        });










    }

    CountDownTimer timer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long l) {
            tv_timer.setText("00:" + countDown);
            countDown--;
        }

        @Override
        public void onFinish() {
            tv_timer.setText("00:00");
            btn_go.setVisibility(View.VISIBLE);
            btn_go.setEnabled(true);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            btn_answer4.setEnabled(false);
        }
    };
}
