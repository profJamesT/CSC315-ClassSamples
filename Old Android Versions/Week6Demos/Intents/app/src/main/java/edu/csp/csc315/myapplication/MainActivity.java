package edu.csp.csc315.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void loadBasicIntentActivity(View v){
        Intent i = new Intent(this, DemoBasicIntentActivity.class);
        startActivity(i);
    }

    public void sendData(View v){
        Intent i = new Intent(this, DataReceiverActivity.class);
        EditText editText = findViewById(R.id.editText);
        i.putExtra("data", editText.getText().toString());
        startActivity(i);
    }

    final static int NAME_VALUE = 9999;

    public void askUser(View v){
        Intent i = new Intent(this, PromptUserActivity.class);
        startActivityForResult(i, NAME_VALUE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == NAME_VALUE && resultCode == RESULT_OK){
            if (data.hasExtra("firstName") || data.hasExtra("lastName")){
                String firstName = data.getExtras().getString("firstName");
                String lastName = data.getExtras().getString("lastName");
                TextView textView = findViewById(R.id.username);
                textView.setText(firstName+ " " + lastName);
            }
        }
    }

    public void gotoSite(View v){
        EditText urlEditText = findViewById(R.id.urlEditText);

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(urlEditText.getText().toString()));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, DemoBasicIntentActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
