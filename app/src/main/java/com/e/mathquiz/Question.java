package com.e.mathquiz;

import android.widget.Button;
import android.widget.TextView;

public class Question {

    private int firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, answer, fAnswer1, fAnswer2, fAnswer3, answerPosition, difficulty, handicap;
    private int[] positions;
    private int[] answers;

    public Question(){
        super();
        this.handicap = 1;
        this.difficulty = 1;
        this.answers = new int[4];
    }

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

        positions = randArray();

        answerPosition = positions[0];
        answers[positions[0]] = answer;
        answers[positions[1]] = fAnswer1;
        answers[positions[2]] = fAnswer2;
        answers[positions[3]] = fAnswer3;

        buttons[0].setText(answers[0]);
        buttons[1].setText(answers[1]);
        buttons[2].setText(answers[2]);
        buttons[3].setText(answers[3]);

        view.setText(firstNumber + " + " + secondNumber );
    }

    public boolean isCorrect(int i){
     if (i == answerPosition){
         return true;
        }
     if (i != answerPosition){
         return false;
     }
     return false;
    }

    private int[] randArray(){
        int size = 4;
        int[] numbers = new int[size];
        int x;
        int counter = 0;
        boolean match;
        while (true){
            match = false;
            x = (int) ((Math.random()* 4.5)+1);
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

}
