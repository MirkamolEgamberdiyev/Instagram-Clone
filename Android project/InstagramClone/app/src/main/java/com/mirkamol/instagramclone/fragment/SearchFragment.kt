package com.mirkamol.instagramclone.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.instagramclone.R
import com.mirkamol.instagramclone.adapter.SearchAdapter
import com.mirkamol.instagramclone.model.User

/*
* In SearchFragment, all registered users can be found bt searching keyword and followed
 */
class SearchFragment : Fragment(R.layout.fragment_search) {
    val TAG = SearchFragment::class.java.simpleName
    lateinit var rv_home: RecyclerView
    var users = ArrayList<User>()
    var items = ArrayList<User>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        rv_home = view.findViewById(R.id.rv_home)
        rv_home.layoutManager = GridLayoutManager(activity, 1)
        val etSearch = view.findViewById<EditText>(R.id.et_search)

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                val keyword = p0.toString().trim()
                userByKeyword(keyword)
            }

            override fun afterTextChanged(p0: Editable) {}
        })

        loadUsers()
        refreshAdapter(items)

    }

    private fun refreshAdapter(items: ArrayList<User>) {
        val adapter = SearchAdapter(this, items)
        rv_home.adapter = adapter

    }


    private fun userByKeyword(keyword: String) {
        if (keyword.isEmpty())
            refreshAdapter(items)

        users.clear()
        for (user in items)
            if (user.fullname.toLowerCase().startsWith(keyword.toLowerCase()))
                users.add(user)

        refreshAdapter(users)

    }

    private fun loadUsers(): ArrayList<User> {
        items = ArrayList()
        items.add(User("Mirkamol", "mira@gmail.com"))
        items.add(User("Mirkamol", "mira@gmail.com"))
        items.add(User("Mirkamol", "mira@gmail.com"))
        items.add(User("Mirkamol", "mira@gmail.com"))
        items.add(User("Mirkamol", "mira@gmail.com"))
        items.add(User("Mirkamol", "mira@gmail.com"))
        items.add(User("Mirkamol", "mira@gmail.com"))
        items.add(User("Mirkamol", "mira@gmail.com"))
        items.add(User("Mirkamol", "mira@gmail.com"))
        items.add(User("Burxoniddin", "mira@gmail.com"))
        items.add(User("Azizbek", "mira@gmail.com"))
        items.add(User("Jaloliddin", "mira@gmail.com"))

        return items
    }

}