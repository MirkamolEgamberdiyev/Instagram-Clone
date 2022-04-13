package com.mirkamol.instagramclonejava.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mirkamol.instagramclonejava.R;


public class HomeFragment extends BaseFragment {
    private HomeListener listener = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initviews(view);
        return view;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof HomeListener) {
            listener = (HomeListener) context;
        }else {
            throw new RuntimeException(context + "must imlement HomeListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener =null;

    }

    private void initviews(View view) {
        ImageView iv_camera = view.findViewById(R.id.iv_camera);
        iv_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert listener != null;
                listener.scrollToUpload();
            }
        });
    }

    /**
     * This interface is created for communications  with UploadFragment
     */
    public interface HomeListener {
        void scrollToUpload();
    }
}