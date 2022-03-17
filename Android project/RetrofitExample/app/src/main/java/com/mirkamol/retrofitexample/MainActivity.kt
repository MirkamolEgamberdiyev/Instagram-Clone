package com.mirkamol.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mirkamol.retrofitexample.ui.comment.CommentFragment
import com.mirkamol.retrofitexample.ui.home.HomeFragment
import com.mirkamol.retrofitexample.ui.profile.ProfileFragment
import com.mirkamol.retrofitexample.ui.search.SearchFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        bottomNavigationView = findViewById(R.id.buttom_navigation)


            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
            bottomNavigationView.setupWithNavController(navHostFragment.navController)

        }

    }
