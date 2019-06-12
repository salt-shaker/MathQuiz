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
    TextView tv_questions, tv_score, tv_timer, tv_multi;
    ProgressBar pb_progressBar;
    int countDown = 60;
    int playerScore = 0;
    int multi = 1;
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
        tv_multi = findViewById(R.id.tv_multi);

        pb_progressBar = findViewById(R.id.pb_progressBar);

        // playGame

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_go.setVisibility(View.GONE);
                btn_answer1.setEnabled(false);
                timer.start();
                q.resetGame();
                q.makeQuestion(tv_questions, buttons);
                btn_answer1.setEnabled(true);
                btn_answer2.setEnabled(true);
                btn_answer3.setEnabled(true);
                btn_answer4.setEnabled(true);
                tv_score.setText(String.valueOf(playerScore));
                tv_multi.setText(multi + "x" + " Boost");
            }
        });

        btn_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(q.isCorrect(0)){
                    playerScore += 10 * multi;
                    q.makeQuestion(tv_questions, buttons);
                    q.updateHandicap(true);
                } else {
                    q.makeQuestion(tv_questions, buttons);
                    q.updateHandicap(false);
                }
                tv_score.setText(String.valueOf(playerScore));
                multi = q.getMulti();
                tv_multi.setText(multi + "x" + " Boost");
            }
        });

        btn_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(q.isCorrect(1)){
                    playerScore += 10 * multi;
                    q.makeQuestion(tv_questions, buttons);
                    q.updateHandicap(true);
                } else {
                    q.makeQuestion(tv_questions, buttons);
                    q.updateHandicap(false);
                }
                tv_score.setText(String.valueOf(playerScore));
                multi = q.getMulti();
                tv_multi.setText(multi + "x" + " Boost");
            }
        });

        btn_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(q.isCorrect(2)){
                    playerScore += 10 * multi;
                    q.makeQuestion(tv_questions, buttons);
                    q.updateHandicap(true);
                } else {
                    q.makeQuestion(tv_questions, buttons);
                    q.updateHandicap(false);
                }
                tv_score.setText(String.valueOf(playerScore));
                multi = q.getMulti();
                tv_multi.setText(multi + "x" + " Boost");
            }
        });

        btn_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(q.isCorrect(3)){
                    playerScore += 10 * multi;
                    q.makeQuestion(tv_questions, buttons);
                    q.updateHandicap(true);
                } else {
                    q.makeQuestion(tv_questions, buttons);
                    q.updateHandicap(false);
                }
                tv_score.setText(String.valueOf(playerScore));
                multi = q.getMulti();
                tv_multi.setText(multi + "x" + " Boost");
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
            countDown = 60;
            playerScore = 0;
            q.resetGame();
            multi = q.getMulti();
            tv_multi.setText(multi + "x" + " Boost");
        }
    };
}
