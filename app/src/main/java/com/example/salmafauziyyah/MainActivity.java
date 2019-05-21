package com.example.salmafauziyyah;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.example.salmafauziyyah.R;
//19-mei-2019,10116596-salmafauziyyah
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBNV;
    private FrameLayout mMainFrame;

    private ProfileFragment profileFragment;
    private KontakFragment kontakFragment;
    private TemanFragment temanFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mBNV = (BottomNavigationView) findViewById(R.id.BNV);

        profileFragment = new ProfileFragment();
        kontakFragment = new KontakFragment();
        temanFragment = new TemanFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                new ProfileFragment()).commit();
        mBNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_profile :
                        setFragment(profileFragment);
                        break;
                    case R.id.nav_kontak :
                        setFragment(kontakFragment);
                        break;

                    case R.id.nav_teman :
                        setFragment(temanFragment);
                        break;
                }
                return true;
            }


        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }


}
