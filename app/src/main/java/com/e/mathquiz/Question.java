package com.e.mathquiz;

import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class Question {

    private int firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, answer, fAnswer1, fAnswer2, fAnswer3, answerPosition, difficulty, handicap;
    private int[] positions;
    private int[] answers;
    private int correctStreak;
    private int wrongStreak;
    private int multi;

    // Constructor
    public Question(){
        super();
        this.handicap = 1;
        this.difficulty = 1;
        this.answers = new int[4];
        this.correctStreak = 0;
        this.wrongStreak = 0;
        this.multi = 0;
    }

    // Makes the addition questions, updates interface
    public void makeQuestion(TextView view, Button[] buttons){
        firstNumber = (int) ((Math.random()*((10/handicap)*difficulty))+1);
        secondNumber = (int) ((Math.random()*((10/handicap)*difficulty))+1);
        thirdNumber = (int) ((Math.random()*((10/handicap)*difficulty))+1);
        fourthNumber = (int) ((Math.random()*((10/handicap)*difficulty))+1);
        fifthNumber = (int) ((Math.random()*((10/handicap)*difficulty))+1);
        answer = firstNumber + secondNumber;
        fAnswer1 = firstNumber + thirdNumber;
        fAnswer2 = firstNumber + fourthNumber;
        fAnswer3 = firstNumber + fifthNumber;

        //Duplicate Check
        if (answer == fAnswer1) fAnswer1++;
        if (answer == fAnswer2) fAnswer2++;
        if (answer == fAnswer3) fAnswer3++;
        if (fAnswer1 == fAnswer2) fAnswer2++;
        if (fAnswer1 == fAnswer3) fAnswer3++;
        if (fAnswer2 == fAnswer3) fAnswer3++;
        if (answer == fAnswer1) fAnswer1++;
        if (answer == fAnswer2) fAnswer2++;
        if (answer == fAnswer3) fAnswer3++;

        // Get new random positions
        positions = randArray();

        // Assign random position to answers
        answerPosition = positions[0];
        answers[positions[0]] = answer;
        answers[positions[1]] = fAnswer1;
        answers[positions[2]] = fAnswer2;
        answers[positions[3]] = fAnswer3;




        // Assign answers to buttons
        buttons[0].setText(String.valueOf(answers[0]));
        buttons[1].setText(String.valueOf(answers[1]));
        buttons[2].setText(String.valueOf(answers[2]));
        buttons[3].setText(String.valueOf(answers[3]));

        // Show questions to user
        view.setText(firstNumber + " + " + secondNumber);
    }

    // Checks if the current question to see if submitted answer is correct
    public boolean isCorrect(int i){
     if (i == answerPosition){
         return true;
        }
     if (i != answerPosition){
         return false;
     }
     return false;
    }

    // Returns a shuffles order list
    private int[] randArray(){
        int size = 4;
        int[] numbers = new int[size];
        int x;
        int counter = 0;
        boolean match;
        while (true){
            match = false;
            x = (int) ((Math.random()* 3.5));
            for(int i = 0; i < numbers.length; i++){
                if (x == numbers[i]){
                    match = true;
                }
            }
            if (!match){
                numbers[counter] = x;
                counter++;
            }
            if(counter == (size-1)) return numbers;
        }
    }

    public void updateHandicap(Boolean t){
        if(t){
            correctStreak++;
            wrongStreak = 0;
        } else if(!t){
            correctStreak = 0;
            wrongStreak++;
        }

        if(correctStreak < 6){
            difficulty = 1;
            setMulti(1);
        } else if (correctStreak > 5 && correctStreak < 11){
            difficulty = 2;
            setMulti(2);
        } else if (correctStreak > 10 && correctStreak < 16){
            difficulty = 3;
            setMulti(3);
        } else if (correctStreak > 15 && correctStreak < 21){
            difficulty = 4;
            setMulti(4);
        } else if (correctStreak > 20 && correctStreak < 26){
            difficulty = 5;
            setMulti(5);
        }

        if(wrongStreak < 6){
            handicap = 1;
        } else if (correctStreak > 5 && correctStreak < 11){
            handicap = 2;
        } else if (correctStreak > 10 && correctStreak < 16){
            handicap = 3;
        } else if (correctStreak > 15 && correctStreak < 21){
            handicap = 4;
        } else if (correctStreak > 20 && correctStreak < 26){
            handicap = 5;
        }
    }

    private void setMulti(int i){
        this.multi = i;
    }

    public int getMulti(){
        return this.multi;
    }

    public void resetGame(){
        this.handicap = 1;
        this.difficulty = 1;
        this.correctStreak = 0;
        this.wrongStreak = 0;
        this.multi = 1;
    }

}
