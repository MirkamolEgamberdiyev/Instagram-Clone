

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.mirkamol.unicornexam.R
import com.wonmirzo.model.CategoryItem
import com.wonmirzo.model.HomeCategoryItem

class CategoryItemAdapter(var context: Context, private var items: ArrayList<CategoryItem>) :
    RecyclerView.Adapter<CategoryItemAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_collection_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryItemAdapter.VH, position: Int) {
        val item = items[position]

        val ivPhoto = holder.ivPhoto
        val tvTitle = holder.tvTitle

        Glide.with(context).load(item.photo).into(ivPhoto)
        tvTitle.text = item.title
    }

    override fun getItemCount(): Int = items.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ImageView = view.findViewById(R.id.ivPhoto)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
    }
}