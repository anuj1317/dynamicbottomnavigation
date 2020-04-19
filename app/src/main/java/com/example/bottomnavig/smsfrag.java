package com.example.bottomnavig;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class smsfrag extends Fragment {
    TextView txtdata;
    String msg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2,container,false);
        txtdata = v.findViewById(R.id.textview);
        txtdata.setText(msg);
        return v;


    }

    public void displayReceivedData(String message)
    {
        msg = message;
    }
}

