package com.mirkamol.instagramclone.fragment

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.instagramclone.R
import com.mirkamol.instagramclone.adapter.ProfileAdapter
import com.mirkamol.instagramclone.model.Post
import com.mirkamol.instagramclone.utils.Logger
import com.sangcomz.fishbun.FishBun
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter

/**
 * In ProfileFragment , post that user uploaded can be seen and user is able to change his/her profile photo
 */

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    val TAG = ProfileFragment::class.java.simpleName
    lateinit var rv_profile:RecyclerView

    var pickedPhoto: Uri? = null
    var allPhotos = ArrayList<Uri>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        rv_profile = view.findViewById(R.id.rv_profile)
        rv_profile.layoutManager = GridLayoutManager(activity, 2)

        val iv_profile = view.findViewById<ShapeableImageView>(R.id.iv_profile)

        iv_profile.setOnClickListener {
            pickFishBunPhoto()
        }

        refreshAdapter(loadPosts())
    }



    /**
     * pick photo using FishBun library
     */
    private fun pickFishBunPhoto() {
        FishBun.with(this)
            .setImageAdapter(GlideAdapter())
            .setMaxCount(1)
            .setMinCount(1)
            .setSelectedImages(allPhotos)
            .startAlbumWithActivityResultCallback(photoLauncher)
    }

    private val photoLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){
            allPhotos = it.data?.getParcelableArrayListExtra(FishBun.INTENT_PATH) ?: arrayListOf()

            pickedPhoto = allPhotos.get(0)
            uploadPickedPhoto()
        }
    }

    private fun uploadPickedPhoto() {
        if (pickedPhoto != null){
            Logger.d(TAG, pickedPhoto!!.path.toString())
        }
    }

    private fun refreshAdapter(items:ArrayList<Post>) {
        val adapter = ProfileAdapter(this, items)
        rv_profile.adapter = adapter
    }

    private fun loadPosts():ArrayList<Post>{
        val items = ArrayList<Post>()
        items.add(Post("https://images.unsplash.com/photo-1649583243101-25f6a6453cfd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"))
        items.add(Post("https://images.unsplash.com/photo-1553603227-2358aabe821e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80"))
        items.add(Post("https://images.unsplash.com/photo-1561618030-ecca407d3ba4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80"))
        items.add(Post("https://images.unsplash.com/photo-1649583243101-25f6a6453cfd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"))
        items.add(Post("https://images.unsplash.com/photo-1553603227-2358aabe821e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1032&q=80"))
        items.add(Post("https://images.unsplash.com/photo-1561618030-ecca407d3ba4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80"))

        return items
    }


}