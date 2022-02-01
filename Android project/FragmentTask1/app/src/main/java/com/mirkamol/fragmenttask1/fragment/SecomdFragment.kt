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
import com.mirkamol.fragmenttask1.listener.SecondListener
import java.lang.RuntimeException

class SecomdFragment : Fragment() {
    var listener: SecondListener? = null
    lateinit var btn_second:Button
    lateinit var tv_second_fragment:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_secomd, container, false)
        tv_second_fragment = view.findViewById(R.id.tv_second_fragment)
        btn_second = view.findViewById(R.id.btn_second)

        btn_second.setOnClickListener {
            listener!!.onSecondSend("Academy")
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SecondListener){
            listener = context
        }else{
            throw RuntimeException(context.toString() + "RuntimeException")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    public fun updateSecondText(text:String){
        tv_second_fragment.setText(text)
    }

}
