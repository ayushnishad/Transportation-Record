package com.example.dbmsmmmut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.bt1);
        button1=findViewById(R.id.bt2);
        //button2=findViewById(R.id.bt3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }


        });
    }
    public void onClick1(View view) {
        Intent intent=new Intent(MainActivity.this,Main3Activity.class);
        startActivity(intent);
        //Toast.makeText(this,"Requires Proper internet Connnection",Toast.LENGTH_SHORT).show();
    }
    /*public void onClick2(View view) {
        Toast.makeText(this,"Requires Proper internet Connnection",Toast.LENGTH_SHORT).show();
    }*/

}
