package com.example.salmafauziyyah;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.example.salmafauziyyah.R;
import java.util.ArrayList;
import java.util.List;

//19-mei-2019,10116596-salmafauziyyah
public class ViewPager extends AppCompatActivity {

    private android.support.v4.view.ViewPager screenPager;
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabIndicator;
    Button btnNext, btnMulai;
    Animation btnAnim;

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        if (restorePrefsData()) {
            Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mIntent);
            finish();
        }


        btnNext = findViewById(R.id.btn_next);
        btnMulai = findViewById(R.id.btn_mulai);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animasi);
        tabIndicator = findViewById(R.id.tabLayout);


        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("1", "", R.drawable.salmafauziyyah));
        mList.add(new ScreenItem("2", "", R.drawable.salmafauziyyah));
        mList.add(new ScreenItem("3", "", R.drawable.salmafauziyyah));

        screenPager = findViewById(R.id.screen_vp);
        viewPagerAdapter = new ViewPagerAdapter(this, mList);
        screenPager.setAdapter(viewPagerAdapter);

        tabIndicator.setupWithViewPager(screenPager);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size()-1){
                    loadLastScreen();
                }
            }
        });

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mIntent);

                savePrefsData();
                finish();
            }
        });
    }

    private boolean restorePrefsData(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean viewPagerTerbukaSebelumnya = pref.getBoolean("VPTerbuka", false);
        return viewPagerTerbukaSebelumnya;
    }

    private void savePrefsData(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("VPTerbuka",true);
        editor.commit();
    }

    private void loadLastScreen(){
        btnNext.setVisibility(View.INVISIBLE);
        btnMulai.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btnMulai.setAnimation(btnAnim);
    }
}
