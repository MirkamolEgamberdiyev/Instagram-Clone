package com.mirkamol.instagramclonejava.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mirkamol.instagramclonejava.R;
import com.mirkamol.instagramclonejava.activity.MainActivity;
import com.mirkamol.instagramclonejava.utils.Logger;
import com.mirkamol.instagramclonejava.utils.Utils;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter;

import java.util.ArrayList;

public class UploadFragment extends BaseFragment {
    private static final String TAG = UploadFragment.class.toString();
    private UploadListener listener = null;
    FrameLayout fl_photo;
    FrameLayout fl_view;
    ImageView iv_photo;
    EditText et_caption;

    Uri pickedPhoto = null;

    ArrayList<Uri> allPhotos = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload, container, false);
        initviews(view);
        return view;
    }

    /**
     * onAttach is for communication of Fragments
     */
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

      if (context instanceof UploadListener) {
          listener = (UploadListener) context;
        }else {
          throw new RuntimeException(context + "must imlement UploadListener");
      }

    }

    /**
     * onDetach is for communication of Fragments
     */
    @Override
    public void onDetach() {
        super.onDetach();
        listener =null;
    }

    private void initviews(View view) {
        fl_view = view.findViewById(R.id.fl_view);
        setViewHeight(fl_view);
        et_caption = view.findViewById(R.id.et_caption);
        fl_photo = view.findViewById(R.id.fl_photo);
        iv_photo = view.findViewById(R.id.iv_photo);

        ImageView iv_close = view.findViewById(R.id.iv_close);
        ImageView iv_pick = view.findViewById(R.id.iv_pick);
        ImageView iv_upload = view.findViewById(R.id.iv_upload);

        fl_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickFishBunPhoto();
            }
        });

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hidePickedPhoto();
            }
        });

        iv_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadNewPost();
            }
        });
    }

    private void uploadNewPost() {
        Logger logger = new Logger();
        String caption = et_caption.getText().toString().trim();
        if (!caption.isEmpty() && pickedPhoto != null) {
            logger.d(TAG, caption);
            logger.d(TAG, pickedPhoto.getPath().toString());

            resetAll();

        }
    }

    private void resetAll() {
        et_caption.getText().clear();
        pickedPhoto = null;
        fl_photo.setVisibility(View.GONE);
    }

    private void hidePickedPhoto() {
        pickedPhoto = null;
        fl_photo.setVisibility(View.VISIBLE);
        fl_view.setVisibility(View.GONE);
    }

    /*
 pick photo using Fishbun library
  */
    private void pickFishBunPhoto() {
        FishBun.with(this)
                .setImageAdapter(new GlideAdapter())
                .setMaxCount(1)
                .setMinCount(1)
                .setSelectedImages(allPhotos)
                .startAlbumWithActivityResultCallback(photoLauncher);

    }

    ActivityResultLauncher<Intent> photoLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {

            if (result.getResultCode() == Activity.RESULT_OK) {
                assert result.getData() != null;
                allPhotos = result.getData().getParcelableArrayListExtra(FishBun.INTENT_PATH);
                pickedPhoto = allPhotos.get(0);

                showPickedPhoto();
            }
        }
    });

    private void showPickedPhoto() {
        fl_photo.setVisibility(View.VISIBLE);
        fl_view.setVisibility(View.GONE);
        iv_photo.setImageURI(pickedPhoto);
    }


    /**
     * Set View height as screen width
     */
    private void setViewHeight(View view) {
        Utils utils = new Utils();
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = utils.screenSize(requireActivity().getApplication()).getWidth();
        view.setLayoutParams(params);
    }

   public interface UploadListener {
         void scrollToHome();
    }
}