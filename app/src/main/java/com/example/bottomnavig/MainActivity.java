package com.example.bottomnavig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, homefrag.I {

    BottomNavigationView bottomnavigation;
    String sendData;
    String senddata2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomnavigation=findViewById(R.id.bottomnavigation);
        showFragment(new homefrag());
        bottomnavigation.setOnNavigationItemSelectedListener(this);




        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if(savedInstanceState !=null){
            senddata2 = savedInstanceState.getString("A1");
        }

        int displaymode = getResources().getConfiguration().orientation;
        if(displaymode == 1)
        {
            homefrag f1 = new homefrag();
            fragmentTransaction.replace(android.R.id.content,f1);
        }
        else
        {
            smsfrag f2 = new smsfrag();
            fragmentTransaction.replace(android.R.id.content,f2);
            if(senddata2!=null){}
            f2.displayReceivedData(senddata2); }
        fragmentTransaction.commit();




    }
               @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId())
                    {
                        case R.id.home:
                            fragment = new homefrag();
                            break;
                        case R.id.sms:
                            fragment = new smsfrag();
                            break;
                        case R.id.fileupload:
                            fragment = new filefrag();
                            break;

                    }
                    return showFragment(fragment);
                }


    private boolean showFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragment)
                    .commit();
            return true;
        }
        return false;
    }



    @Override
    public void communicate(String msg)
    {
        sendData = msg;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("A1",sendData);
    }






}
