package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class Sports extends Fragment {
    RecyclerView recyclerView;
    Context context;

    String sports[] ={"Cricket ", "Football ", "Badminton ", "Athletics " };
    String coach[] = {"Sahil Kumbhar ", "Sunil Dsouza ", "Diljeet Singh ","Fahad Shaikh"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sports, container, false);
        recyclerView =view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        CustomAdapter c = new CustomAdapter(coach, sports);
        recyclerView.setAdapter(c);
        return view;
    }
}