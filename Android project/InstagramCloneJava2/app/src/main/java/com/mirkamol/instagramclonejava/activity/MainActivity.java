package com.mirkamol.instagramclonejava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mirkamol.instagramclonejava.R;
import com.mirkamol.instagramclonejava.adapter.ViewPagerAdapter;
import com.mirkamol.instagramclonejava.fragments.FavoriteFragment;
import com.mirkamol.instagramclonejava.fragments.HomeFragment;
import com.mirkamol.instagramclonejava.fragments.ProfileFragment;
import com.mirkamol.instagramclonejava.fragments.SearchFragment;
import com.mirkamol.instagramclonejava.fragments.UploadFragment;

public class MainActivity extends BaseActivity implements UploadFragment.UploadListener, HomeFragment.HomeListener {
    private static final String TAG = MainActivity.class.toString();
    int index = 0;
    HomeFragment homeFragment;
    UploadFragment uploadFragment;
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initviews();
    }
    

    @Override
    public void scrollToUpload() {
        index = 2;
        scrollByIndex(index);
    }

    @Override
    public void scrollToHome() {
        index = 0;
        scrollByIndex(index);
    }

    private void scrollByIndex(int index) {
        viewPager.setCurrentItem(index);
        bottomNavigationView.getMenu().getItem(index).setChecked(true);
    }




    @SuppressLint("NonConstantResourceId")
    private void initviews() {
        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                case R.id.navigation_search:
                    viewPager.setCurrentItem(1);
                case R.id.navigation_upload:
                    viewPager.setCurrentItem(2);
                case R.id.navigation_favorite:
                    viewPager.setCurrentItem(3);
                case R.id.navigation_profile:
                    viewPager.setCurrentItem(4);
            }
            return true;
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                index = position;
                bottomNavigationView.getMenu().getItem(index).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        // Home and Upload Fragments are global for communication purpose

        homeFragment = new HomeFragment();
        uploadFragment = new UploadFragment();
        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(homeFragment);
        adapter.addFragment(new SearchFragment());
        adapter.addFragment(uploadFragment);
        adapter.addFragment(new FavoriteFragment());
        adapter.addFragment(new ProfileFragment());
        viewPager.setAdapter(adapter);


    }


}