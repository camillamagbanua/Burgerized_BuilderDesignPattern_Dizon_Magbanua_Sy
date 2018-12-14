package burger.burgerized;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;

import android.os.Bundle;

import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.ListAdapter;

import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

import java.util.List;

import burger.burgerized.DatabaseHelper;
import burger.burgerized.R;


public class your_bag extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    TextView total;
    DatabaseHelper mDatabaseHelper;
    private ListView mListView;
    static float totalOrders;
    //float totalOrders = wendys_combos.totalOrders + wendys_sides.totalOrders ;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_bag);
        mListView = (ListView) findViewById(R.id.orders);
        mDatabaseHelper = new DatabaseHelper(this);
        total = findViewById(R.id.total);
        populateListView();

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        String chosen = mPreferences.getString("chosen", "wendys");

        totalOrders = 0;
        if (chosen == "wendys") {
            totalOrders = wendys_combos.totalOrders + wendys_sides.totalOrders;
        }
        else if (chosen == "bk") {
            totalOrders = bk_combos.totalOrders + bk_sides.totalOrders;
        }

        String totalDisplay = Float.toString(totalOrders);
        total.setText("P"+totalDisplay);

        FloatingActionButton bag = findViewById(R.id.checkOut);
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openApp = new Intent(getApplicationContext(), finish.class);
                startActivity(openApp);
                wendys_combos.totalOrders = 0;
                wendys_sides.totalOrders = 0;
                bk_combos.totalOrders = 0;
                bk_sides.totalOrders = 0;
                finish();
            }
        });
    }
    private void populateListView() {
        //Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }
        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

    }



}