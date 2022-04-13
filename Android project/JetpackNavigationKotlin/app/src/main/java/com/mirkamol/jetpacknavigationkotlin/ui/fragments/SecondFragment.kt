package com.mirkamol.jetpacknavigationkotlin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mirkamol.jetpacknavigationkotlin.R
import com.mirkamol.jetpacknavigationkotlin.databinding.FragmentSecondBinding
import com.mirkamol.jetpacknavigationkotlin.utils.viewBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private val binding by viewBinding { FragmentSecondBinding.bind(it) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.DoNotClick.setOnClickListener {
            findNavController().navigate(R.id.thirdFragment)
        }

    }

}