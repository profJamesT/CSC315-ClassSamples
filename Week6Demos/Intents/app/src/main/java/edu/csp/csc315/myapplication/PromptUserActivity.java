package edu.csp.csc315.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PromptUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt_user);
    }

    public void finish(){
        Intent data = new Intent();

        EditText firstNameEditText = findViewById(R.id.firstName);
        EditText lastnameEditText = findViewById(R.id.lastName);

        data.putExtra("firstName", firstNameEditText.getText().toString());
        data.putExtra("lastName", lastnameEditText.getText().toString());
        setResult(RESULT_OK, data);
        super.finish();
    }

    public void submit(View v){
        finish();
    }
}
