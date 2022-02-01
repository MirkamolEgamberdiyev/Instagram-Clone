package com.mirkamol.fragmentclasswork;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {
    private static final String KEY = "the_key";

   public static SecondFragment newInstance(String text){
       SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, text);
        fragment.setArguments(bundle);
        return fragment;
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView textView = view.findViewById(R.id.tv_second_fragment);
        textView.setText(getArguments().getString(KEY));
        return view;
    }
}