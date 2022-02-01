package com.mirkamol.fragmenttask4_5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmenttask5.R
import com.example.fragmenttask5.adapter.ContactAdapter
import com.example.fragmenttask5.model.Contact

class FragmentContact : Fragment() {

    private var contactList = ArrayList<Contact>()
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        initViews(view)
        return view;
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_contact)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        contactAdapter = ContactAdapter(contactList())
        recyclerView.adapter = contactAdapter
    }

    private fun contactList(): ArrayList<Contact> {
        for (i in 0..30) {
            contactList.add(Contact("Mirkamol", "+998 93 492 35 17"))
        }
        return contactList
    }
}