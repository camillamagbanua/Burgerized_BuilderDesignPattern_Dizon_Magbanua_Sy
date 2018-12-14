package burger.burgerized;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeration";
    public static final String COL_1="ID";
    public static final String COL_2="Name";
    public static final String COL_3="Password";
    public static final String COL_4="Email";
    public static final String COL_5="Phone";

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE2_NAME = "Orders";
    private static final String T2_COL1 = "ID";
    private static final String T2_COL2 = "Item";
    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Password TEXT,Email TEXT,Phone TEXT)");
        db.execSQL("CREATE TABLE " + TABLE2_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Item TEXT)");
        //        String query = "CREATE TABLE " + TABLE2_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + T2_COL2 + "TEXT)";
//        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME); //Drop older table if exists
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE2_NAME); //Drop older table if exists
        onCreate(db);
    }

    public boolean addData(String item) {
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(T2_COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE2_NAME, T2_COL2, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Returns all the data from database
     * @return
     */
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE2_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Returns only the ID that matches the name passed in
     * @param items
     * @return
     */
    public Cursor getItemID(String items){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + T2_COL1 + " FROM " + TABLE2_NAME +
                " WHERE " + T2_COL2 + " = '" + items + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void delete(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE2_NAME);
    }

}