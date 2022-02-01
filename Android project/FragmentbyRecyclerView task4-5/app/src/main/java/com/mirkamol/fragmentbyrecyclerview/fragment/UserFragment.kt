package com.mirkamol.fragmentbyrecyclerview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.fragmentbyrecyclerview.R
import com.mirkamol.fragmentbyrecyclerview.adapters.UserAdapter
import com.mirkamol.fragmentbyrecyclerview.model.User

class UserFragment : Fragment() {

    private lateinit var userAdapter: UserAdapter
    private lateinit var users: ArrayList<User>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.rv_user)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        users = addUser()

        refreshAdapter()
    }
    private fun refreshAdapter() {
        userAdapter = UserAdapter(users)
        recyclerView.adapter = userAdapter
    }

    private fun addUser():ArrayList<User>{
        val users = ArrayList<User>()
        for (i in 0..10){
            users.add(User("Mirkamol Egamberdiyev", "4567890"))
            users.add(User("Khurshid Kobilov", "4567890"))
            users.add(User("Sherzod Abdullajonov", "45567890"))
            users.add(User("Jaloliddin Abdullayev", "4567890"))
            users.add(User("To'khtamurod Isroilov", "45678"))
            users.add(User("Shoxrux Gafurof", "4657890"))
            users.add(User("Ibrohim Makhamadaliyev", "34567"))
        }
        return users
    }
}
