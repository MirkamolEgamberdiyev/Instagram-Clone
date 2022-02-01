package com.mirkamol.fragmenttask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mirkamol.fragmenttask1.fragment.FirstFragment
import com.mirkamol.fragmenttask1.fragment.SecomdFragment
import com.mirkamol.fragmenttask1.listener.FirstListener
import com.mirkamol.fragmenttask1.listener.SecondListener

class MainActivity : AppCompatActivity(), FirstListener, SecondListener {
    lateinit var firstFragment: FirstFragment
    lateinit var secondFragment: SecomdFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

    }

    private fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecomdFragment()

        supportFragmentManager.beginTransaction().replace(R.id.fragment_first, firstFragment)
            .replace(R.id.fragment_second, secondFragment).commit()

    }

    override fun onFirstSend(text: String) {
        secondFragment.updateSecondText(text)

    }

    override fun onSecondSend(text: String) {
      firstFragment.updateFirstText(text)
    }
}