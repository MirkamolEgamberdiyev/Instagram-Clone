package com.example.fragmenttask5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttask5.R
import com.example.fragmenttask5.adapter.UserAdapter
import com.example.fragmenttask5.model.User


class FragmentUser : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter:UserAdapter
    private var userList = ArrayList<User>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false);
        initViews(view)
        return view;
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycler_user )
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        userAdapter = UserAdapter(userList())
        recyclerView.adapter = userAdapter
    }
    private fun userList(): ArrayList<User> {
        for (i in 0..30) {
            userList.add(User("User","He was born in Uzbekistan,\n his phoneNumber is \n+998 99 9900990",R.drawable.img_sample_user))
        }
        return userList
    }

}