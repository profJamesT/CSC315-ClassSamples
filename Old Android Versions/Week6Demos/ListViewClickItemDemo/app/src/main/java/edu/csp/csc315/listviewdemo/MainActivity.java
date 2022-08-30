package edu.csp.csc315.listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Date> dateArrayList = new ArrayList<Date>();
    private ArrayAdapter<Date> adapter;
    private ListView listView;
    private Date date;
    private int selectedPosition = 0;
    public final static int DATE_CHANGE = 15;

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
                date = new Date();
                dateArrayList.add(date);
                adapter.notifyDataSetChanged();

                Snackbar.make(view, date + " is deleted.", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new UndoAction()).show();
            }
        });

        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dateArrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickAction());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode ==  DATE_CHANGE && resultCode == RESULT_OK){
            Date d = new Date(data.getExtras().getString("date"));
            dateArrayList.set(selectedPosition, d);
            adapter.notifyDataSetChanged();
        }
    }

    class OnItemClickAction implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectedPosition = position;
            Date item = dateArrayList.get(position);
            Intent i = new Intent(MainActivity.this, DetailActivity.class);
            i.putExtra("date", item.toString());
            startActivityForResult(i, DATE_CHANGE);
        }
    }

    class UndoAction implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (date==null) return;
            if (!dateArrayList.contains(date)) dateArrayList.add(date);
            else dateArrayList.remove(date);
            adapter.notifyDataSetChanged();

            Snackbar.make(v, date + " has been restored.", Snackbar.LENGTH_LONG)
                    .setAction("Undo", new UndoAction()).show();
        }
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
        if (id == R.id.action_remove_all) {
            dateArrayList.clear();
            adapter.notifyDataSetChanged();
            date = null;
            return true;
        }else if (id==R.id.action_remove_first){
            if (dateArrayList.size()>0)  {
                date = dateArrayList.get(0);
                dateArrayList.remove(date);
                adapter.notifyDataSetChanged();
            }
            return true;
        }else if (id==R.id.action_remove_last){
            if (dateArrayList.size()>0){
                date = dateArrayList.get(dateArrayList.size()-1);
                dateArrayList.remove(date);
                adapter.notifyDataSetChanged();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
