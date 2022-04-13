package com.mirkamol.instagramclone.fragment

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.bumptech.glide.util.Util
import com.mirkamol.instagramclone.R
import com.mirkamol.instagramclone.utils.Logger
import com.mirkamol.instagramclone.utils.Utils
import com.mirkamol.instagramclone.utils.toast
import com.sangcomz.fishbun.FishBun
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter
import java.lang.RuntimeException

/*
* in UploadFragment, user can upload
* a post with photo and caption
 */

class UploadFragment : BaseFragment() {
    val TAG = UploadFragment::class.java.simpleName
    private var listener:UploadListener? = null

    lateinit var fl_photo: FrameLayout
    lateinit var fl_view: FrameLayout
    lateinit var iv_photo: ImageView
    lateinit var et_caption: EditText

    var pickedPhoto: Uri? = null
    var allPhotos = ArrayList<Uri>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_upload, container, false)
        initViews(view)
        return view
    }

    /**
     * onAttach is for communication of Fragments
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is UploadListener){
            context
        }else{
            throw RuntimeException("$context must imlement UploadListener")
        }
    }
    /**
     * onDetach is for communication of Fragments
     */
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun initViews(view: View) {
        fl_view = view.findViewById(R.id.fl_view)
        setViewHeight(fl_view)
        et_caption = view.findViewById(R.id.et_caption)
        fl_photo = view.findViewById(R.id.fl_photo)
        iv_photo = view.findViewById(R.id.iv_photo)

        val iv_close = view.findViewById<ImageView>(R.id.iv_close)
        val iv_pick = view.findViewById<ImageView>(R.id.iv_pick)
        val iv_upload = view.findViewById<ImageView>(R.id.iv_upload)

        fl_view.setOnClickListener {
            pickFishBunPhoto()
        }

        iv_close.setOnClickListener {
            hidePickedPhoto()
        }

        iv_upload.setOnClickListener {
            uploadNewPost()
        }
    }

    /**
     * Set View height as screen width
     */

    private fun setViewHeight(view: View) {
        val params: ViewGroup.LayoutParams = view.layoutParams
        params.height = Utils.screenSize(requireActivity().application).width
        view.layoutParams = params

    }


    private fun uploadNewPost() {
        val caption = et_caption.text.toString().trim()
        if (caption.isNotEmpty() && pickedPhoto != null) {
            listener!!.scrollToHome()
            Logger.d(TAG, caption)
            Logger.d(TAG, pickedPhoto!!.path.toString())
            resetAll()
        }
    }

    private fun hidePickedPhoto() {
        pickedPhoto = null
        fl_photo.isVisible = true
        fl_view.isVisible = false
    }

    /*
    pick photo using Fishbun library
     */
    private fun pickFishBunPhoto() {
        FishBun.with(this)
            .setImageAdapter(GlideAdapter())
            .setMaxCount(1)
            .setMinCount(1)
            .setSelectedImages(allPhotos)
            .startAlbumWithActivityResultCallback(photoLauncher)

    }

    private val photoLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                allPhotos =
                    it.data?.getParcelableArrayListExtra(FishBun.INTENT_PATH) ?: arrayListOf()
                pickedPhoto = allPhotos[0]
                showPickedPhoto()
            }
        }


    private fun showPickedPhoto() {
        fl_photo.isVisible = true
        fl_view.isVisible = false
        iv_photo.setImageURI(pickedPhoto)
    }

    private fun resetAll() {
        et_caption.text.clear()
        pickedPhoto = null
        fl_photo.visibility = View.GONE
    }
    /*
    this interface is created for communication whith HomeFragment
     */
    interface UploadListener{
        fun scrollToHome()
    }

}


