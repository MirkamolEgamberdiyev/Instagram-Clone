package com.mirkamol.jetpacknavigationkotlin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.mirkamol.jetpacknavigationkotlin.R
import com.mirkamol.jetpacknavigationkotlin.databinding.FragmentHomeBinding
import com.mirkamol.jetpacknavigationkotlin.utils.viewBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding { FragmentHomeBinding.bind(it) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.clickMe.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_secondFragment,
                bundleOf("key" to "value")
            )
        }
    }

}