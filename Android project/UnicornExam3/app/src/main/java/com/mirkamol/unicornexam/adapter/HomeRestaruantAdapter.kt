
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirkamol.unicornexam.R
import com.wonmirzo.model.HomeCategoryItem
import com.wonmirzo.model.HomeRestaruantsItem

class HomeRestaruantAdapter(
    var context: Context,
    private var items: ArrayList<HomeRestaruantsItem>
) :
    RecyclerView.Adapter<HomeRestaruantAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRestaruantAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_restaruants_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HomeRestaruantAdapter.VH, position: Int) {
        val item = items[position]

        val ivPhoto = holder.ivPhoto
        val tvFoodName = holder.tvFoodName
        val tvAddress = holder.tvAddress
        val rbFood = holder.rbFood

        Glide.with(context).load(item.photo).into(ivPhoto)
        tvFoodName.text = item.name
        tvAddress.text = item.address
        rbFood.rating = item.stars
    }

    override fun getItemCount(): Int = items.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ImageView = view.findViewById(R.id.ivPhoto)
        val tvFoodName: TextView = view.findViewById(R.id.tvFoodName)
        val tvAddress: TextView = view.findViewById(R.id.tvAddress)
        val rbFood: RatingBar = view.findViewById(R.id.rbFood)
    }
}