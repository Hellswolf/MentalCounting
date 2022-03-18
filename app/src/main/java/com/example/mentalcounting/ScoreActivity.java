package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class ScoreActivity extends AppCompatActivity  {

    TextView  operation,percentOfSucces,lastOperation;
    GenerateCalcul calculClass = new GenerateCalcul(1,1,"");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        associateOpenActivityToButton(R.id.button3, MainActivity.class);

        operation = (TextView) findViewById(R.id.textView);
        percentOfSucces = (TextView) findViewById(R.id.textView2);
        lastOperation = (TextView) findViewById(R.id.textView3);
        getArrayScore();
    }

    private void associateOpenActivityToButton(int id,Class activity){
        Button button = findViewById(id);
        button.setOnClickListener(view -> openActivity(activity));

    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);

    }

    public void getArrayScore(){

        operation.setText("Nombre total de calcul : "+calculClass.getTotalCalcul());

        int score = calculClass.getScore();
        int totalCalcul = calculClass.getTotalCalcul();

        float fractionOfTotal = (float)score/totalCalcul;
        float percent = fractionOfTotal * 100;
        int percentRound = Math.round(percent);
        percentOfSucces.setText("Total de bonne réponse : " +percentRound+"%");
    }
}