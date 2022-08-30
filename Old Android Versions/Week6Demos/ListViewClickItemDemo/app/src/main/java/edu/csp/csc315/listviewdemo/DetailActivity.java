package edu.csp.csc315.listviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String date = extras.getString("date");
            EditText editText = findViewById(R.id.editText);
            editText.setText(date);
            new Date(date);
        }
    }

    public void update(View v){
        finish();
    }

    public void finish(){
        Intent data = new Intent();
        EditText editText = findViewById(R.id.editText);
        String date = editText.getText().toString();
        data.putExtra("date", date);
        setResult(RESULT_OK, data);
        super.finish();
    }
}
