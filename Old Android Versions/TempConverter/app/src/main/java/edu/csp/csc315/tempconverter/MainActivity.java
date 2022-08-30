package edu.csp.csc315.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button convertButton = (Button)findViewById(R.id.convertButton);
        Button clearButton = (Button)findViewById(R.id.clearButton);

        convertButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TextView fValue = (TextView)findViewById(R.id.fValue2);
                TextView cValue = (TextView)findViewById(R.id.cValue);

                float fFloat = Integer.parseInt(fValue.getText().toString());
                float cFloat = (float)(fFloat - 32) * (float)(5.0/9.0);


                cValue.setText(String.format("%.2f", cFloat));
            }
        });

    }
}
