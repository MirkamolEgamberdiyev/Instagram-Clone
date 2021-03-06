package com.mirkamol.pinterestclonemyproject.ui.fragments

import android.os.Bundle
import android.text.Html
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.imageview.ShapeableImageView
import com.jsibbold.zoomage.ZoomageView
import com.mirkamol.pinterestclonemyproject.R
import com.mirkamol.pinterestclonemyproject.adapter.SearchPhotoAdapter
import com.mirkamol.pinterestclonemyproject.database.Saved
import com.mirkamol.pinterestclonemyproject.database.SavedDatabase
import com.mirkamol.pinterestclonemyproject.model.homephoto.HomePhotoItem
import com.mirkamol.pinterestclonemyproject.model.reletedconnection.SinglePhoto
import com.mirkamol.pinterestclonemyproject.model.search.ResponseSearch
import com.mirkamol.pinterestclonemyproject.networking.ApiClient
import com.mirkamol.pinterestclonemyproject.networking.service.ApiService
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DatailFragment : Fragment(R.layout.fragment_datail), View.OnClickListener {
    private lateinit var apiService: ApiService
    private lateinit var ivDetailPhoto: ZoomageView
    private lateinit var ivProfile: ShapeableImageView
    private lateinit var tvUsername: TextView
    private lateinit var tvNumFollowers: TextView
    private lateinit var tvSave: TextView
    private lateinit var tvComment: TextView
    private lateinit var ivBack: ImageView
    private lateinit var ivMore: ImageView
    private lateinit var ivShare: ImageView
    private lateinit var navController: NavController
    private lateinit var savedDatabase: SavedDatabase

    private lateinit var rvLikeThis: RecyclerView
    private lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager

    private var PAGE = 1
    private var PER_PAGE = 20

    private lateinit var bottomSheetLayout: CoordinatorLayout
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<CoordinatorLayout>

    lateinit var imageUrl: String
    lateinit var imageID: String
    lateinit var imageDescription: String
    var relatedPhotoAdapter = SearchPhotoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        apiService = ApiClient(requireContext()).createServiceWithAuth(ApiService::class.java)
        imageUrl = arguments?.get("photoUrl").toString()
        imageID = arguments?.get("photoID").toString()
        imageDescription = arguments?.get("description").toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
    }

    private fun initViews(view: View) {
        navController = Navigation.findNavController(view)
        ivDetailPhoto = view.findViewById(R.id.ivDetailPhoto)
        loadImage(imageUrl)

        ivProfile = view.findViewById(R.id.ivProfile)
        tvUsername = view.findViewById(R.id.tvUsername)
        tvNumFollowers = view.findViewById(R.id.tvNumFollowers)

        setLoaderProfile()


        tvComment = view.findViewById(R.id.tvComment)

        ivBack = view.findViewById(R.id.isBack)
        ivMore = view.findViewById(R.id.ivMore)
        ivShare = view.findViewById(R.id.ivShare)
        tvSave = view.findViewById(R.id.tvSave)

        rvLikeThis = view.findViewById(R.id.rvLikeThis)
        staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvLikeThis.layoutManager = staggeredGridLayoutManager
        rvLikeThis.adapter = relatedPhotoAdapter

        getRelated()

        controlClick()


        ivBack.setOnClickListener(this)
        ivMore.setOnClickListener(this)
        ivShare.setOnClickListener(this)
        tvSave.setOnClickListener(this)


        bottomSheetLayout = view.findViewById(R.id.bottomSheetMore)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        controlBottomSheetAction(bottomSheetLayout)

        savedDatabase = SavedDatabase.getInstance(requireContext())

    }

    private fun controlBottomSheetAction(bottomSheetLayout: CoordinatorLayout?) {
        val ivCloseBottomSheet: ImageView =
            bottomSheetLayout!!.findViewById(R.id.icCloseBottomSheet)
        val tvCopyLink: TextView = bottomSheetLayout.findViewById(R.id.tvCopyLink)
        val tvDownloadImage: TextView = bottomSheetLayout.findViewById(R.id.tvDownloadImage)

        ivCloseBottomSheet.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }


    }

    private fun getRelated() {
        apiService.getImageToRelated(imageID).enqueue(object : Callback<SinglePhoto> {
            override fun onResponse(call: Call<SinglePhoto>, response: Response<SinglePhoto>) {
                Log.d("ResponceReleted", response.body().toString())
                val tags = response.body()!!.related_collections.results[0].tags
                var query = ""
                for (i in 0 until tags.size - 1)
                    query += tags[i].title + " "

                getSearchResults(query.trim())
            }

            override fun onFailure(call: Call<SinglePhoto>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.localizedMessage}")
            }
        })
    }

    private fun getSearchResults(query: String) {
        apiService.searchPhotos(query, PAGE++, PER_PAGE)
            .enqueue(object : Callback<ResponseSearch> {
                override fun onResponse(
                    call: Call<ResponseSearch>,
                    response: Response<ResponseSearch>
                ) {
                    relatedPhotoAdapter.submitData(response.body()!!.results)
                }

                override fun onFailure(call: Call<ResponseSearch>, t: Throwable) {
                }
            })
    }

    private fun controlClick() {
        relatedPhotoAdapter.photoClick = {
            navController.navigate(
                R.id.action_datailFragment_self,
                bundleOf(
                    "photoID" to it.id,
                    "photoUrl" to it.urls.regular,
                    "description" to it.description
                )
            )
        }
    }


    private fun setLoaderProfile() {
        apiService.getSelectedPhoto(arguments?.get("photoID").toString()).enqueue(object :
            Callback<HomePhotoItem> {
            override fun onResponse(
                call: Call<HomePhotoItem>,
                response: Response<HomePhotoItem>
            ) {
                val homePhotoItem = response.body() as HomePhotoItem
         Glide.with(requireContext()).load(homePhotoItem.user.profile_image.medium).into(ivProfile)

                tvUsername.text = homePhotoItem.user.name

                val source = "Love this Pin? Let " + "<b>${tvUsername.text}<\b>"
                tvComment.text = Html.fromHtml(source)
            }

            override fun onFailure(call: Call<HomePhotoItem>, t: Throwable) {

            }

        })
    }

    private fun loadImage(imageUrl: String) {
        Picasso.get()
            .load(imageUrl)
            .into(ivDetailPhoto)
    }

    override fun onClick(p0: View?) {

        when (p0!!.id) {
            R.id.isBack -> {
                navController.navigate(R.id.action_datailFragment_to_homeFragment)
            }

            R.id.ivMore -> {
                if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                } else {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                }
            }
            R.id.ivShare -> {

            }

            R.id.tvSave ->{
                saveDatabase(imageID,imageUrl, imageDescription)
            }



        }
    }


    private fun saveDatabase(imageId:String, imageUrl: String, imageDescription:String){
        savedDatabase.savedDao().insertProduct(Saved(imageId, imageUrl, imageDescription))
    }

}