package com.example.patrickspc.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    Button playAgainButton;
    TextView counterResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        playAgainButton = (Button) findViewById(R.id.playAgainButton);
        counterResult = (TextView) findViewById(R.id.resultView);

        //The data from the GuessingActivity seems to not be able to pass over to the ResultsActivity
        Bundle getCounter = getIntent().getExtras();
        String value = getCounter.getString("COUNTER");
        counterResult.setText(value);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
                startActivity(intent);
            }
        });
    }
}




