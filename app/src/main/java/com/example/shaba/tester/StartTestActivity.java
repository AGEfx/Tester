package com.example.shaba.tester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartTestActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button btn;

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_test);
        //region Элементы экрана
        editText = findViewById(R.id.et_get_id);
        btn = findViewById(R.id.start_btn);

        btn.setOnClickListener(this);
        //endregion Элементы экрана


    }

    @Override
    public void onClick(View v) {
        String text =editText.getText().toString();
        if (editText.getText().toString() != null && !editText.getText().toString().equals("")
                && editText.getText().toString() != null && !editText.getText().toString().equals(""))
            startActivity(new Intent(this, TestActivity.class));
        else
            Toast.makeText(this, "Необходимо заполнить все поля", Toast.LENGTH_SHORT).show();
    }
}
