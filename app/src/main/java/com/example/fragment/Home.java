package com.example.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;


public class Home extends Fragment implements View.OnClickListener {

    ImageButton cricket_btn,football_btn,athletics_btn,badminton_btn;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_home, container, false);
       cricket_btn = v.findViewById(R.id.cric_btn);
       football_btn = v.findViewById(R.id.foot_btn);
       badminton_btn = v.findViewById(R.id.bad_btn);
       athletics_btn = v.findViewById(R.id.athl_btn);
       return v;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cric_btn:
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment_Cricket myFragment = new Fragment_Cricket();
                activity.getSupportFragmentManager().beginTransaction().replace
                        (R.id.fragment_container2, myFragment).addToBackStack(null).commit();
        }

    }
}