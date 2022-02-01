package com.mirkamol.fragmentclasswork;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {
    private static final String KEY = "the_key";
    public FirstFragment(){

    }
    public FirstFragment(String text){
        Bundle bundle = new Bundle();
        bundle.putString(KEY, text);
        setArguments(bundle);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        TextView textView = view.findViewById(R.id.tv_first_fragment);
        textView.setText(getArguments().getString(KEY));
        return view;
    }
}