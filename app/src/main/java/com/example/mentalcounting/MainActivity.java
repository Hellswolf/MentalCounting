package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        associateOpenActivityToButton(R.id.button, GameActivity.class);
        associateOpenActivityToButton(R.id.button2, ScoreActivity.class);

    }

    private void associateOpenActivityToButton(int id,Class activity){
        Button button = findViewById(id);
        button.setOnClickListener(view -> openActivity(activity));

    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);

    }
}