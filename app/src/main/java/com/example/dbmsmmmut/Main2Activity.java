package com.example.dbmsmmmut;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main2Activity extends AppCompatActivity /*implements AdapterView.OnItemClickListener*/ {
    Spinner spinner;
    Button button;
    RadioButton r1,r2,rb;
    RadioGroup rg;
    EditText et1,et2,et3,et6;
    String mode,sender,reciever,address,arrdate,depdate,supply,veh;
    TextView ddate,adate;
    private DatePickerDialog.OnDateSetListener mdate1,mdate2;
    DatabaseReference user;

//    ListView listViewUser;
//    List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner=findViewById(R.id.spinner);
        button=findViewById(R.id.button);
        rg=findViewById(R.id.group);
        et1=findViewById(R.id.editText1);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        ddate=findViewById(R.id.editText4);
        adate=findViewById(R.id.editText5);
        et6=findViewById(R.id.editText6);

//      listViewUser=findViewById(R.id.listViewUser);
//      userList=new ArrayList<>();

        user=FirebaseDatabase.getInstance().getReference("user");

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Vehical_no));
       // r1=findViewById(R.id.send);
       // r2=findViewById(R.id.recieve);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemClickListener(this);

        mdate1=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                arrdate = day + "/" + month + "/" + year;
                //Toast.makeText(this,""+date,Toast.LENGTH_SHORT).show();
                ddate.setText(arrdate);

            }
        };

            mdate2=new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    month=month+1;
                    depdate= day +"/"+ month +"/" + year;
                    //Toast.makeText(this,""+date,Toast.LENGTH_SHORT).show();
                    adate.setText(depdate);

                }
        };

    }


   /* @Override
    protected void onStart() {
        super.onStart();

        user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userList.clear();
                for(DataSnapshot userSnapshot : dataSnapshot.getChildren())
                {
                    User user= userSnapshot.getValue(User.class);
                    userList.add(user);
                }
                ArrayAdapter adapter= new UserList(Main2Activity.this,userList);
                listViewUser.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/

    public void cal11(View view)
    {
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog=new DatePickerDialog(this,R.style.Theme_AppCompat_Light_Dialog_MinWidth,mdate1,year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.show();
    }

    public void cal12(View view)
    {
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog=new DatePickerDialog(this,R.style.Theme_AppCompat_Light_Dialog_MinWidth,mdate2,year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.show();
    }


    public void buttonChecked(View view)
    {
        int radioId= rg.getCheckedRadioButtonId();
        rb=findViewById(radioId);
        mode=(rb.getText()).toString();
        Toast.makeText(this,""+mode,Toast.LENGTH_SHORT).show();
    }


    public void here(View view)
    {
        sender=et1.getText().toString();
        reciever=et2.getText().toString();
        address=et3.getText().toString();
        supply=et6.getText().toString();
        veh=spinner.getSelectedItem().toString();
        // Write a message to the database
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, Ayush");*/

        //Toast.makeText(this,id+" "+name+" "+address+" "+supply+" "+veh,Toast.LENGTH_SHORT).show();


        String id= user.push().getKey();
        User ur = new User(mode,sender,reciever,address,arrdate,depdate,veh,supply);
        user.child(id).setValue(ur);

        Toast.makeText(this,"Database Updated",Toast.LENGTH_SHORT).show();
    }
    /*@Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        veh=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this," "+veh,Toast.LENGTH_SHORT).show();
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.send:
                if (checked)
                    Toast.makeText(this,"Send",Toast.LENGTH_SHORT).show();// Pirates are the best
                break;
            case R.id.recieve:
                if (checked)
                    Toast.makeText(this,"Recieve",Toast.LENGTH_SHORT).show();// Ninjas rule
                break;
        }
    }*/
}
