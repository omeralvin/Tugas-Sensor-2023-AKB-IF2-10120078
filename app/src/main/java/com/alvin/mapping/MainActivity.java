package com.alvin.mapping;
//10120078 - Alvin Izza Rohman -IF2
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.alvin.mapping.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

//    private Activity DataBindingUtil;
//    ActivityMainBinding binding ;

    private BottomNavigationView bnview;
    private profilFragment profilf = new profilFragment();
    private infoFragment infof = new infoFragment();
    private Map5Fragment pinmap = new Map5Fragment();
    private MapNowFragment maplocation = new MapNowFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnview = findViewById(R.id.bnv);
        bnview.setOnItemSelectedListener(this);
        bnview.setSelectedItemId(R.id.profile);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.framing, profilf).commit();
                return true;
            case R.id.mapNow:
                getSupportFragmentManager().beginTransaction().replace(R.id.framing, maplocation).commit();
                return true;
            case R.id.Map5:
                getSupportFragmentManager().beginTransaction().replace(R.id.framing, pinmap).commit();
                return true;
            case R.id.info:
                getSupportFragmentManager().beginTransaction().replace(R.id.framing, infof).commit();
                return true;
        }
        return false;
    }
}