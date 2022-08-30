package edu.csp.csc315.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_receiver);

        Bundle extras = getIntent().getExtras();

        if (extras != null){
            String data = extras.getString("data");
            TextView textView = findViewById(R.id.textView2);
            textView.setText(data);
        }
    }
}
