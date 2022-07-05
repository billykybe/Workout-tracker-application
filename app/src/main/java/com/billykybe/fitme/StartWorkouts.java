package com.billykybe.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class StartWorkouts extends AppCompatActivity {
    ProgressBar progressBar ;
    TextView counter ,skipcount;

    int modifier=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workouts);


        String id = getIntent().getStringExtra("id");


        skipcount= findViewById(R.id.fi_continue);

        progressBar = findViewById(R.id.gr_progressbar);
        progressBar.setMax(15);
counter = findViewById(R.id.counter_text);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (modifier >= 0){
counter.setText(""+modifier);
progressBar.setProgress(modifier);
modifier--;
handler.postDelayed(this,1000);
                }else {

                    Intent intent = new Intent(getApplicationContext(),WorkoutScreen.class);
                  intent.putExtra("id",id);
                    startActivity(intent);
                    finish();
                }

            }
        },1500);
        skipcount.setOnClickListener(view -> {
handler.removeCallbacksAndMessages(null);
            Intent intentTo = new Intent(getApplicationContext(),WorkoutScreen.class);
            intentTo.putExtra("id",id);
            startActivity(intentTo);
            finish();
        });
    }
}