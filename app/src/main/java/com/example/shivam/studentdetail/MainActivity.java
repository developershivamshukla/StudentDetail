package com.example.shivam.studentdetail;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    StudentRecord st;
    Button sm,get,getOne;
    EditText e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        st=new StudentRecord(this);
        sm = findViewById(R.id.bSubmit);
        get = findViewById(R.id.bFRECORD);
        getOne = findViewById(R.id.getRecord);
        e1 = findViewById(R.id.roll);
        e2 = findViewById(R.id.name);
        e3 = findViewById(R.id.mob);
        e4 = findViewById(R.id.city);

        sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st.studentdata(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString());
                Toast.makeText(MainActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                cln();

            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder b = new StringBuilder();
                Cursor c = st.getrecord();
                if (c.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "Data Not Found...", Toast.LENGTH_SHORT).show();
                }
                while (c.moveToNext()) {
                    b.append("Roll=>" + c.getString(0) + "\n" + "Name=>" + c.getString(1) + "\n" + "Mobile=>" + c.getString(2) + "\n" + "City=>" + c.getString(3) + "\n");

                }
                Intent i = new Intent(MainActivity.this, Data.class);
                i.putExtra("k", b.toString());
                startActivity(i);
            }
        });
        getOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = st.getOne(e1.getText().toString());
                //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                if (e1.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                } else if (c.moveToFirst()) {
                    String rt = "Name=>" + c.getString(1) + "\n" + "Mobile=>" + c.getString(2) + "\n" + "City=>" + c.getString(3) + "\n";
                    Intent i = new Intent(MainActivity.this, Data.class);
                    i.putExtra("k", rt);
                    startActivity(i);
                } else if (c.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "Not Found...", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
            public void cln()
            {
            e1.setText(null);
            e1.requestFocus();
            e2.setText(null);
            e3.setText(null);
            e4.setText(null);
             }


}
