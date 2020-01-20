package com.example.dbmsmmmut;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    DatabaseReference user;

    ListView listViewUser;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        user= FirebaseDatabase.getInstance().getReference("user");

        listViewUser=findViewById(R.id.listViewUser);
        userList=new ArrayList<>();
    }



        @Override
        protected void onStart () {
            try{

        super.onStart();

        user.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userList.clear();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    User user = userSnapshot.getValue(User.class);
                    userList.add(user);
                }
                ArrayAdapter adapter = new UserList(Main3Activity.this, userList);
                listViewUser.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

            }
            catch(Exception exception)
            {
                Toast.makeText(this,"Exception caught " +exception ,Toast.LENGTH_SHORT).show();
            }
    }

}
