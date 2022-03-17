package com.mirkamol.taxiui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mirkamol.taxiui.R
import com.mirkamol.taxiui.adapter.CirySelectionAdapter
import com.mirkamol.taxiui.model.Region

class CitySelectionBottomSheet(val type: Int) : BottomSheetDialogFragment() {
    private val adapter by lazy { CirySelectionAdapter() }

    companion object {
        const val ACTION_FROM = 0
        const val ACTION_TO = 1
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context)
            .inflate(R.layout.city_selection_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var txtType = view.findViewById<TextView>(R.id.txt_type)
        val rvRegion = view.findViewById<RecyclerView>(R.id.recycler_view)
        txtType.text = if (type == ACTION_FROM) "Qayerdan?" else "Qayerga"

        val layoutManager  = LinearLayoutManager(requireContext())
        rvRegion.layoutManager =layoutManager

        rvRegion.adapter = adapter


        var list = ArrayList<Region>()
        list.add(Region("Namangan"))
        list.add(Region("Toshkent"))
        list.add(Region("Buxoro"))
        list.add(Region("Farg'ona"))
        list.add(Region("Andijon"))
        list.add(Region("Navoiy"))
        list.add(Region("Sirdaryo"))


        adapter.submitData(list)

        adapter.itemclick = {
            Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
        }

    }

}