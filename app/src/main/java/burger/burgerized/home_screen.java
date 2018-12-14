package burger.burgerized;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class home_screen extends AppCompatActivity {
    ImageButton wendys;
    ImageButton bk;
    TextView header, total;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        mDatabaseHelper = new DatabaseHelper(this);

        bk = findViewById(R.id.bk);
        wendys = findViewById(R.id.wend);
        header = findViewById(R.id.header);

        header.setText("Welcome, " + LogIn.custName);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();


        wendys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("chosen", "wendys");
                mEditor.commit();
                delete();
                wendys_combos.totalOrders=0;
                wendys_sides.totalOrders=0;

                Intent openApp = new Intent(getApplicationContext(), wendys.class);
                startActivity(openApp);
               // finish();
            }
        });
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.putString("chosen", "bk");
                mEditor.commit();
                delete();
                //total = findViewById(R.id.total);
                //total.setText("P0.0");


                bk_combos.totalOrders=0;
                bk_sides.totalOrders=0;
                Intent openApp = new Intent(getApplicationContext(), wendys.class);
                startActivity(openApp);
                //finish();
            }
        });
    }

    public void delete(){
        mDatabaseHelper.delete();
    }
}
