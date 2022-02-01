package com.mirkamol.fragmentbyrecyclerview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.fragmentbyrecyclerview.R
import com.mirkamol.fragmentbyrecyclerview.adapters.ContactAdapter
import com.mirkamol.fragmentbyrecyclerview.model.Contact


class ContactFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var contactList: ArrayList<Contact>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        contactList = addContacts()
        recyclerView = view.findViewById(R.id.rv_contact)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        refreshAdapter()
    }

    private fun refreshAdapter() {
        contactAdapter = ContactAdapter(contactList)
        recyclerView.adapter = contactAdapter
    }

    private fun addContacts(): ArrayList<Contact> {
        val contacts = ArrayList<Contact>()

        for (i in 0..100) {
            contacts.add(Contact(R.drawable.contact_image, "Mirkamol Egamberdiyev", "+998974697907"))
            contacts.add(Contact(R.drawable.contact_image, "Muhammadyusuf Saliyev", "+998905202951"))
        }
        return contacts
    }
}