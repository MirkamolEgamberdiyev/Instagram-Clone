
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirkamol.unicornexam.R
import com.wonmirzo.model.MessageItem

class MessageItemAdapter(var context: Context, private var items: ArrayList<MessageItem>) :
    RecyclerView.Adapter<MessageItemAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageItemAdapter.VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_message_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MessageItemAdapter.VH, position: Int) {
        val item = items[position]

        val ivPhoto = holder.ivPhoto
        val tvFullName = holder.tvFullName

        Glide.with(context).load(item.photo).into(ivPhoto)
        tvFullName.text = item.name
    }

    override fun getItemCount(): Int = items.size

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val ivPhoto: ImageView = view.findViewById(R.id.ivPhoto)
        val tvFullName: TextView = view.findViewById(R.id.tvFullName)
    }
}