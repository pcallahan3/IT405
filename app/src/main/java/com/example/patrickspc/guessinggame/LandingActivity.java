package com.example.patrickspc.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {

    Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        findViews();
        bindButtonClick();

    }

    void findViews(){

        startGameButton = (Button) findViewById(R.id.startGameButton);
    }

    void bindButtonClick(){

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GuessingActivity.class);
                startActivity(intent);
            }
        });
    }

}