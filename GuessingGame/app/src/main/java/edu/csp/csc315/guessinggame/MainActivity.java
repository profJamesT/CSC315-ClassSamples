package edu.csp.csc315.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int secretValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secretValue = (int)(Math.random() * 100 + 1);
        //System.out.println("The number is: " + secretValue);

        Button guessButton = (Button)findViewById(R.id.guessButton);

        guessButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TextView tvResult = (TextView)findViewById(R.id.guessResultText);
                TextView tvGuess = (TextView)findViewById(R.id.guessText);

                //convert to numbers
                int guess = Integer.parseInt(tvGuess.getText().toString());
                if (guess == secretValue) {
                    tvResult.setText("You guessed my number");
                } else if (guess < secretValue) {
                    tvResult.setText("Your guess is too LOW");
                } else {
                    tvResult.setText("Your guess is too HIGH");
                }

            }
        });
    }



}
