package edu.csp.timestamplist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity  {

    private ArrayList<String> items = null;
    private ArrayAdapter<String> arrayAdapter = null;
    private ListView listView = null;
    private DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHelper = new DatabaseHelper(this);

        //YOU MUST INITIALIZE items...pain will follow if you don't
//        items = new ArrayList<String>();
        items = dbHelper.getAll();

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, items);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Date d = new Date();

                items.add(d.toString());
                dbHelper.add(d.toString());

                arrayAdapter.notifyDataSetChanged();

                Snackbar.make(view, d.toString() + " is added", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener(){
                            public void onClick(View v){
                                items.remove(d.toString());
                                dbHelper.remove(d.toString());
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }).show();
            }
        });
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
            items.clear();
            dbHelper.removeAll();
            arrayAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
