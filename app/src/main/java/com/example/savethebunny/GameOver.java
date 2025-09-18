package com.example.savethebunny;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    TextView tvPoints;
    TextView tvHighest;
    SharedPreferences sharedPreferences;
    ImageView isNewHighest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        tvPoints=findViewById(R.id.tvpoints);
        tvHighest=findViewById(R.id.tvHighest);
        isNewHighest=findViewById(R.id.isNewHighest);
        int points=getIntent().getExtras().getInt("points");
        tvPoints.setText(""+points);
        sharedPreferences=getSharedPreferences("my_pref",0);
        int highest=sharedPreferences.getInt("highest",0);
        if(points>highest){
            isNewHighest.setVisibility(View.VISIBLE);
            highest=points;
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putInt("highest",highest);
            editor.commit();
        }
        tvHighest.setText(""+highest);

    }
    public void restart(View v){
        Intent i=new Intent(GameOver.this,MainActivity.class);
        startActivity(i);
        finish();
    }
    public void exit(View v){
        finish();
    }
}
