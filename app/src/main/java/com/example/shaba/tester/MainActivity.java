package com.example.shaba.tester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button sTestBtn;
    Button crTestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sTestBtn = findViewById(R.id.start_test_btn);
        crTestBtn = findViewById(R.id.create_test_btn);
        sTestBtn.setOnClickListener(this);
        crTestBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_test_btn:
                startActivity(new Intent(this, StartTestActivity.class));
                break;
            case R.id.create_test_btn:
                startActivity(new Intent(this, CreatingTestActivity.class));
                break;
        }
    }
}
