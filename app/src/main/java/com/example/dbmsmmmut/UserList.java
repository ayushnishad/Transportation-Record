package com.example.dbmsmmmut;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserList extends ArrayAdapter <User> {

    private Activity content;
    private List <User> userList;

    public UserList(Activity content,List<User> userList)
    {
        super (content, R.layout.list_layout,userList);
        this.content=content;
        this.userList=userList;
    }

   // @androidx.annotation.NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater=content.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.list_layout,null,true);

        TextView textViewMode= listViewItem.findViewById(R.id.textView9);
        TextView textViewReciever= listViewItem.findViewById(R.id.textView11);
        TextView textViewSender= listViewItem.findViewById(R.id.textView12);
        TextView textViewAddress= listViewItem.findViewById(R.id.textView13);
        TextView textViewDDate= listViewItem.findViewById(R.id.textView14);
        TextView textViewADate= listViewItem.findViewById(R.id.textView15);
        TextView textViewVeh= listViewItem.findViewById(R.id.textView16);
        TextView textViewSupply= listViewItem.findViewById(R.id.textView17);

        User user= userList.get(position);
        textViewMode.setText("Mode : "+user.getMode());
        textViewReciever.setText("Reciever Name : "+user.getReciever());
        textViewSender.setText("Sender Name : "+user.getSender());
        textViewAddress.setText("Address : "+user.getAddress());
        textViewADate.setText("Arrival Date : "+user.getAdate());
        textViewDDate.setText("Departure Date : "+user.getDdate());
        textViewVeh.setText("Vehical No. "+user.getVeh());
        textViewSupply.setText("Suppy : "+user.getSupply());


        return  listViewItem;

    }
}
