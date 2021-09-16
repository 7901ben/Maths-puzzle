package com.hfad.mathsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonStart;
    TextView questionTextView ;
    Button button0,button1,button2,button3;
    TextView scoreTextView;
    TextView timerTextView;
    Button buttonFinish;
    Button buttonBlank;
    int Answer;                                                                 //Answer
    int score = 0;                                              //Score to be displayed
    int questionNumber = 0;
    int Finish=0;
    public void blank(View view){
        Toast.makeText(MainActivity.this,"Plz click Start to begin",Toast.LENGTH_LONG).show();
    }
    public void start(final View view){
        Log.i("info", "start: ");
        buttonBlank.setVisibility(View.INVISIBLE);              //makes blank button vissible
        question();
        view.setVisibility(View.INVISIBLE);                    // makes start button invisible
        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(Long.toString(millisUntilFinished/1000));    //displays time
            }

            @Override
            public void onFinish() {
                buttonFinish = findViewById(R.id.buttonFinish);
                buttonFinish.setVisibility(View.VISIBLE);
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        }.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonStart = findViewById(R.id.buttonStart);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        buttonBlank = findViewById(R.id.buttonBlank);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }//oncreate

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:{
                int correctWrong;         //correctWrong gets the text in button and usedto compare with answer to determine result
                correctWrong =  Integer.parseInt( button0.getText().toString());
                Log.i("info", Integer.toString(correctWrong));
                if(correctWrong == Answer){                                                         //display Toast correct or wrong
                    Toast.makeText(MainActivity.this,"Correct ",Toast.LENGTH_SHORT).show();
                    score++;                                                                           //score increment
                }else{
                    Toast.makeText(MainActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
                questionNumber++;                                                                   //question increment
                scoreTextView.setText(String.valueOf(score)+"/"+String.valueOf(questionNumber) );   //textview update
                question();                                                                         //creates new question
                break;
            }
            case R.id.button1:{
                int correctWrong;         //correctWrong gets the text in button and usedto compare with answer to determine result
                correctWrong =  Integer.parseInt( button1.getText().toString());
                Log.i("info", Integer.toString(correctWrong));
                if(correctWrong == Answer){                                                         //display Toast correct or wrong
                    Toast.makeText(MainActivity.this,"Correct ",Toast.LENGTH_SHORT).show();
                    score++;                                                                           //score increment
                }else{
                    Toast.makeText(MainActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
                questionNumber++;                                                                   //question increment
                scoreTextView.setText(String.valueOf(score)+"/"+String.valueOf(questionNumber) );   //textview update
                question();  //creates new question
                break;
            }
            case R.id.button2:{
                int correctWrong;         //correctWrong gets the text in button and usedto compare with answer to determine result
                correctWrong =  Integer.parseInt( button2.getText().toString());
                Log.i("info", Integer.toString(correctWrong));
                if(correctWrong == Answer){                                                         //display Toast correct or wrong
                    Toast.makeText(MainActivity.this,"Correct ",Toast.LENGTH_SHORT).show();
                    score++;                                                                           //score increment
                }else{
                    Toast.makeText(MainActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
                questionNumber++;                                                                   //question increment
                scoreTextView.setText(String.valueOf(score)+"/"+String.valueOf(questionNumber) );   //textview update
                question();    //creates new question
                break;
            }
            case R.id.button3:{
                int correctWrong;         //correctWrong gets the text in button and usedto compare with answer to determine result
                correctWrong =  Integer.parseInt( button3.getText().toString());
                Log.i("info", Integer.toString(correctWrong));
                if(correctWrong == Answer){                                                         //display Toast correct or wrong
                    Toast.makeText(MainActivity.this,"Correct ",Toast.LENGTH_SHORT).show();
                    score++;                                                                           //score increment
                }else{
                    Toast.makeText(MainActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                }
                questionNumber++;                                                                   //question increment
                scoreTextView.setText(String.valueOf(score)+"/"+String.valueOf(questionNumber) );   //textview update
                question();  //creates new question
                break;
            }
        }//switch
    }//onClick
    public void question(){
        Random rand = new Random();         //generate random numbers for the button
        int a,b,c,d;
        a = rand.nextInt(40);
        b = rand.nextInt(40);
        c = rand.nextInt(40);
        d= rand.nextInt(40);
        button0.setText(Integer.toString(a));
        button1.setText(Integer.toString(b));
        button2.setText(Integer.toString(c));
        button3.setText(Integer.toString(d));

        int num1,num2;                 //random number for Questions
        num1 = rand.nextInt(20);
        num2 = rand.nextInt(20);
        Answer = num1+num2;
        questionTextView = findViewById(R.id.questionTextView);       //changing the question
        questionTextView.setText(Integer.toString(num1)+"+"+Integer.toString(num2));
        int buttonNoForCorrectAnswer;                                  //setting correct answer for one button
        buttonNoForCorrectAnswer = rand.nextInt(3);
        Log.i("random","random "+ Integer.toString(buttonNoForCorrectAnswer));

        if(buttonNoForCorrectAnswer==0){
            button0.setText(Integer.toString(Answer));
        }else if(buttonNoForCorrectAnswer==1){
            button1.setText(Integer.toString(Answer));
        }else  if(buttonNoForCorrectAnswer==2){
            button2.setText(Integer.toString(Answer));
        }else if(buttonNoForCorrectAnswer==3){
            button3.setText(Integer.toString(Answer));

        }
    }
}//main activity