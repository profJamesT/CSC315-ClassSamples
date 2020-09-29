package edu.csp.csc315.demoone;

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

        Button plus = (Button)findViewById(R.id.incrementButton);
        plus.setOnClickListener(new PlusClickListener());

        Button minus = (Button)findViewById(R.id.decrementButton);
        minus.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v){
                        TextView tv = (TextView) findViewById(R.id.currentValueText);
                        int value = Integer.parseInt(tv.getText().toString());
                         value--;
                        tv.setText(Integer.toString(value));
                 }
                }
                );
//        minus.setOnClickListener(new MinusClickListener());

        Button plusplus = (Button)findViewById(R.id.btnPlusPlus);
        plusplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.currentValueText);
                int value = Integer.parseInt(tv.getText().toString());
                value+=2;
                tv.setText(Integer.toString(value));
            }
        });
    }

    class PlusClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // get the textview and read the string
            // convert the string to an integer
            // add one to the integer, place it in the text field

            //sample uses value
            TextView tv = (TextView)findViewById(R.id.currentValueText);
            int value = Integer.parseInt(tv.getText().toString()); //we need string because android like CharSequences
            value++;
            tv.setText(Integer.toString(value));
        }
    }

//    class MinusClickListener implements View.OnClickListener {
//        public void onClick(View v) {
//            TextView tv = (TextView)findViewById(R.id.currentValueText);
//            int value = Integer.parseInt(tv.getText().toString());
//            value--;
//            tv.setText(Integer.toString(value));
//        }
//    }
}
