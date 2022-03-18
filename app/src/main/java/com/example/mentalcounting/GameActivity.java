package com.example.mentalcounting;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class GameActivity extends AppCompatActivity {

    Random rand = new Random();
    EditText operationTxt;
    TextView operation,isValid,isInvalid;


    int fNumber = rand.nextInt(20);
    int sNumber = rand.nextInt(10);
    String[] listOfOperator = {"+", "*", "-", "/"};
    GenerateCalcul calculClass = new GenerateCalcul(fNumber,sNumber,listOfOperator[rand.nextInt(listOfOperator.length)]);

    int goodAnswers,badAnswers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button button = (Button) findViewById(R.id.submit);

        operation = (TextView) findViewById(R.id.operation);
        isValid = (TextView) findViewById(R.id.valid);
        isInvalid = (TextView) findViewById(R.id.invalid);

        operationTxt = (EditText) findViewById(R.id.editTextNumber);
        refresh();



        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               Correction();
                      if (sNumber == 0 || fNumber == 0) {
                           refresh();
                }
            }
        });


    }





    //refresh le calcul

     public void refresh(){
        fNumber = rand.nextInt(40);
        sNumber = rand.nextInt(20);
        calculClass = new GenerateCalcul(fNumber,sNumber,listOfOperator[rand.nextInt(listOfOperator.length)]);
        calculClass.generateCalcul();
        operation.setText(calculClass.generateCalcul());
    }
    //corection du calcul
    public void Correction(){
        String txt = operationTxt.getText().toString();
        int parseTxt = parseInt(txt);

        if (parseTxt == calculClass.resultCase()){
            calculClass.setScore();
            goodAnswers++;
            isValid.setText("Bonne réponse :" + goodAnswers);
            calculClass.setTotalCalcul();
            refresh();
        }else{
            badAnswers++;
            isInvalid.setText("Mauvaise réponse : "+ badAnswers);
            calculClass.setTotalCalcul();
            refresh();
        }

    }

}