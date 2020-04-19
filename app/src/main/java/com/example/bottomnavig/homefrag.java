package com.example.bottomnavig;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


    public class homefrag extends Fragment {
        EditText edtText;
        String msg;
        homefrag.I i1;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {

            View v = inflater.inflate(R.layout.fragment_1,container,false);
            edtText = v.findViewById(R.id.edittext);

            edtText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

                @Override
                public void afterTextChanged(Editable editable) {
                    i1.communicate(edtText.getText().toString());

                }
            });
            return v;
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            i1 = (homefrag.I)context;
        }

        interface I
        {
            void communicate(String msg);
        }

    }
