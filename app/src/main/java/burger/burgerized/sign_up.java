package burger.burgerized;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_up extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText _txtname, _txtpass, _txtemail, _txtphone;
    Button _btnreg, _btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);


        openHelper = new DatabaseHelper(this);
        _txtname = findViewById(R.id.name);
        _txtpass = findViewById(R.id.pass);
        _txtemail = findViewById(R.id.emailAdd);
        _txtphone = findViewById(R.id.phoneNo);
        _btnreg = findViewById(R.id.signUp);

        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(_txtname.getText()) || TextUtils.isEmpty(_txtpass.getText()) || TextUtils.isEmpty(_txtemail.getText())
                        || TextUtils.isEmpty(_txtphone.getText())){
                    Toast.makeText(getApplicationContext(), "Please fill up the required forms", Toast.LENGTH_LONG).show();
                }
                else {
                    db = openHelper.getWritableDatabase();
                    String name = _txtname.getText().toString();
                    String pass = _txtpass.getText().toString();
                    String email = _txtemail.getText().toString();
                    String phone = _txtphone.getText().toString();
                    insertdata(name, pass, email, phone);
                    Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();
                    finish();
                }

            }
        });
    }
    public void insertdata(String name, String pass, String email, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, name);
        contentValues.put(DatabaseHelper.COL_3, pass);
        contentValues.put(DatabaseHelper.COL_4, email);
        contentValues.put(DatabaseHelper.COL_5, phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}
