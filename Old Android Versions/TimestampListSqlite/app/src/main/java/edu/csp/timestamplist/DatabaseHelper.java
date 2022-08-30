package edu.csp.timestamplist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    private final static String DB_NAME = "timestamp";

    private final static int VERSION = 1;

    public DatabaseHelper(Context ct){
        super(ct, DB_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        //create a table named timestamp_table
        //the field is timestamp and it's characters.
        db.execSQL("CREATE TABLE timestamp_table (timestamp TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if new version, drop the old table.
        db.execSQL("DROP TABLE IF EXISTS timestamp_table");

        //recreate the new table.
        onCreate(db);
    }

    public void add(String item){

        //package stuff to insert into the database
        ContentValues values = new ContentValues();
        values.put("timestamp", item);

        //get a reference to the database with write permission
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("timestamp_table", null, values);
        db.close();
    }

    public ArrayList<String> getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> items = new ArrayList<String>();

        //get all timestamps from the table and add them to the arraylist
        Cursor cursor = db.rawQuery("SELECT * FROM timestamp_table", null);
        cursor.moveToFirst();
        for(int i=0; i<cursor.getCount(); i++){
            items.add(cursor.getString(0));
            cursor.moveToNext();
        }
        db.close();
        return items;
    }

    public void remove(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("timestamp_table", "timestamp=?", new String[]{item});
        db.close();
    }

    public void removeAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("timestamp_table", null, null);
        db.close();
    }
}
