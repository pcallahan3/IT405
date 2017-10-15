package com.example.patrickspc.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GuessingActivity extends AppCompatActivity {

    Button checkButton;
    EditText numberInput;
    Random r = new Random();
    int randomNum = r.nextInt(20 - 1) + 1;
    int counter = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        checkButton = (Button) findViewById(R.id.checkButton);
        numberInput = (EditText) findViewById(R.id.enterNumberText);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check to
                if (isEmpty(numberInput)) {
                    Toast emptyNumberInput = Toast.makeText(getApplicationContext(), "Please enter a number!", Toast.LENGTH_LONG);
                    emptyNumberInput.show();

                } else if (Integer.parseInt(numberInput.getText().toString()) >= 1 || Integer.parseInt(numberInput.getText().toString()) <= 20) {
                    if (Integer.parseInt(numberInput.getText().toString()) == randomNum) {
                        counter++;
                        Toast correctNumber = Toast.makeText(getApplicationContext(), "Correct ", Toast.LENGTH_LONG);
                        correctNumber.show();
                        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                        intent.putExtra("COUNTER", GuessingActivity.this.counter);
                        startActivity(intent);

                    } else if (Integer.parseInt(numberInput.getText().toString()) > randomNum) {
                        counter++;
                        Toast correctNumber = Toast.makeText(getApplicationContext(), "Too high " , Toast.LENGTH_LONG);
                        correctNumber.show();

                    } else if (Integer.parseInt(numberInput.getText().toString()) < randomNum) {
                        counter++;
                        Toast correctNumber = Toast.makeText(getApplicationContext(), "Too low ", Toast.LENGTH_LONG);
                        correctNumber.show();

                    }
                }
            }
        });

        }

    private boolean isEmpty(EditText checkText) {
        if (checkText.getText().toString().trim().length() > 0){
            return false;
        }
        return true;
    }


}