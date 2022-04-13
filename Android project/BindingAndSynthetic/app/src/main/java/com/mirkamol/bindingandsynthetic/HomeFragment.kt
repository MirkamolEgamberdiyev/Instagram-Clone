package com.mirkamol.bindingandsynthetic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mirkamol.bindingandsynthetic.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
//    private var _bn:FragmentHomeBinding? = null
//    private val bn get() = _bn!!
    private val binding by viewBinding{FragmentHomeBinding.bind(it)}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      //  _bn = FragmentHomeBinding.bind(view)

//        bn.tvTextView.setOnClickListener {
//
//        }


        binding.tvTextView.setOnClickListener {

        }

    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _bn = null
//    }
}