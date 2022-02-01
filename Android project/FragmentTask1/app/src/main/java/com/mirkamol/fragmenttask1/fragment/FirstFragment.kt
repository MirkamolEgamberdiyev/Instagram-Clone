package com.mirkamol.fragmenttask1.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.mirkamol.fragmenttask1.R
import com.mirkamol.fragmenttask1.listener.FirstListener
import java.lang.RuntimeException

class FirstFragment : Fragment() {
    var listener: FirstListener? = null
    lateinit var btn_first: Button
    lateinit var tv_first_fragment: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        tv_first_fragment = view.findViewById(R.id.tv_first_fragment)
        btn_first = view.findViewById(R.id.btn_first)
        btn_first.setOnClickListener {
            listener!!.onFirstSend("PDP")
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FirstListener){
            listener = context
        }else{
            throw RuntimeException(context.toString() + "RuntimeException")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    public fun updateFirstText(text:String){
        tv_first_fragment.setText(text)
    }

}