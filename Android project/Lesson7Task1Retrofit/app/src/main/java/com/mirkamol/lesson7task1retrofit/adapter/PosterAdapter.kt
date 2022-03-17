import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.lesson7task1retrofit.MainActivity
import com.mirkamol.lesson7task1retrofit.R
import com.mirkamol.lesson7task1retrofit.model.Poster

class PosterAdapter(var activity: MainActivity, val items: List<Poster>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class PosterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        val tvBody = view.findViewById<TextView>(R.id.tv_body)
        val llPoster = view.findViewById<LinearLayout>(R.id.ll_poster)
        val tvId = view.findViewById<TextView>(R.id.tvId)
        val tvUserId = view.findViewById<TextView>(R.id.tvUserId)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return PosterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val poster = items[position]

        if (holder is PosterViewHolder) {
            val ll_poster = holder.llPoster
            ll_poster.setOnClickListener {
                activity.dialogPoster(poster.id)
                false
            }

            holder.tvTitle.text = poster.title.toUpperCase()
            holder.tvBody.text = poster.body
            holder.tvId.text = poster.id.toString()
            holder.tvUserId.text = poster.userId.toString()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}