package com.mirkamol.telegramcontactpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.telegramcontactpage.Adapter.CustomContactAdapter
import com.mirkamol.telegramcontactpage.model.Contact

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        refreshAdapter(addAllContacts())
    }

    private fun refreshAdapter(contacts: ArrayList<Contact>) {
        val adapter = CustomContactAdapter(this, contacts)
        recyclerView.adapter = adapter
    }

    private fun addAllContacts(): ArrayList<Contact> {
        val contacts = ArrayList<Contact>()

        for (i in 0..20) {
            contacts.add(Contact(R.drawable.ic_image, "Mirkamol", "last seen recently"))
        }
        return contacts
    }


}