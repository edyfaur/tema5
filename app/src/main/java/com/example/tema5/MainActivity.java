package com.example.tema5;

import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Random rand = new Random();
    private int targetNumber;
    private TextView guessStatus;
    private EditText userGuessInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessStatus = findViewById(R.id.guess_status);
        userGuessInput = findViewById(R.id.user_guess_input);
        generateTargetNumber();
    }

    public void generateTargetNumber() {
        targetNumber = rand.nextInt(100);
    }

    public void checkGuess(View view) {
        int userGuess = Integer.parseInt(userGuessInput.getText().toString());
        if (userGuess == targetNumber) {
            guessStatus.setText("You got it! The number was " + targetNumber + ". Press New Game to play again.");
        } else if (userGuess < targetNumber) {
            guessStatus.setText("Your guess is too low. Try again.");
        } else if (userGuess > targetNumber) {
            guessStatus.setText("Your guess is too high. Try again.");
        }
    }

    public void newGame(View view) {
        generateTargetNumber();
        userGuessInput.setText("");
        guessStatus.setText("Make a guess!");
    }
}
