package com.example.newsfeed;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.college_name:
                    Toast.makeText(getApplicationContext(), "SMVEC", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.college_details:
                    Toast.makeText(getApplicationContext(), "college details", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.progress:
                    Toast.makeText(getApplicationContext(), "Student progress", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.co_activitiy:
                    Toast.makeText(getApplicationContext(), "co-curricular activity", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.settings:
                    Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };
}
