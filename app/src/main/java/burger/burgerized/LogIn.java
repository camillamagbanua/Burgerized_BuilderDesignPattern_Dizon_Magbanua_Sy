package burger.burgerized;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    Button _btnLogin;
    EditText _txtEmail, _txtPass;
    static String custName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button signUp = findViewById(R.id.signUp);


        _txtEmail=findViewById(R.id.emailAdd);
        _txtPass=findViewById(R.id.pass);
        _btnLogin=findViewById(R.id.signIn);
        openHelper=new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openApp = new Intent(getApplicationContext(), sign_up.class);
                startActivity(openApp);
            }
        });
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = _txtEmail.getText().toString();
                String pass = _txtPass.getText().toString();

                cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_4 + "=? AND " + DatabaseHelper.COL_3 + "=?", new String[]{email, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                         custName = cursor.getString(cursor.getColumnIndex("Name"));
                        //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                         Intent openApp = new Intent(getApplicationContext(), home_screen.class);
                        startActivity(openApp);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "User cannot be found. Check if you've entered the correct Email and Password.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
