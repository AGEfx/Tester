package com.example.shaba.tester;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatingTestActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1;
    EditText editText2;
    Button btn;

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_creating);
        editText1 = findViewById(R.id.et_set_id);
        editText2 = findViewById(R.id.et_set_title);
        btn = findViewById(R.id.create_btn);

        btn.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        String text = editText2.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        if (editText1.getText().toString().trim().length() > 0 && editText2.getText().toString().trim().length() > 0){
            contentValues.put(DBHelper.KEY_TITLE,text);
            database.insert(DBHelper.TABLE_TESTS,null,contentValues);

            Cursor cursor = database.query(DBHelper.TABLE_TESTS,null,null,null,null,null,null);
            if (cursor.moveToFirst()){
                int index = cursor.getColumnIndex(DBHelper.KEY_TITLE);
                do {
                    Log.d("nLog", "TITLE = " + cursor.getString(index));
                }while (cursor.moveToNext());
            }else Log.d("mLog"," 0 rows");
            cursor.close();

            startActivity(new Intent(this, ManageTestActivity.class));
        }
        else
            Toast.makeText(this, "Необходимо заполнить все поля", Toast.LENGTH_SHORT).show();
    }
}
