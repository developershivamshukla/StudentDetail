package com.example.shivam.studentdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Data extends AppCompatActivity {
    TextView t;
    StudentRecord st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        t=findViewById(R.id.textView);
        Intent i = getIntent();
        t.setText(i.getStringExtra("k"));
    }
}
