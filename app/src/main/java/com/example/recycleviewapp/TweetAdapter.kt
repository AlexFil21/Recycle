import android.content.ContentValues.TAG
import android.graphics.drawable.Drawable
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewapp.R
import kotlinx.android.synthetic.main.rv_header.view.*
import kotlinx.android.synthetic.main.rv_img.view.*
import kotlinx.android.synthetic.main.rv_list_item.view.*

class TweetAdapter : RecyclerView.Adapter<TweetAdapter.TweetViewHolder>(){
    var tweetList: ArrayList<Any> = ArrayList()


    fun setItems(item : ArrayList<Any>){
        this.tweetList = item
        notifyDataSetChanged()
    }

    class TweetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card = itemView.tv_list_item
        fun bind(str: String,  position: Int){
            card.text = str
        }
    }

    class TweetView2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card = itemView.rvImg
        fun bind(str: Any,  position: Int){
            card.background = str as Drawable?
        }
    }

    class TweetView3Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card = itemView.rvHeader
        fun bind(str: String,  position: Int){
            card.text = str
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(tweetList[position]) {
            is String -> {
                0
            }
            is Image -> {
                1
            }
            else -> {
                2
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        Log.i("hereIsType", viewType.toString())
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == 0) {
            TweetViewHolder(layoutInflater.inflate(R.layout.rv_list_item, parent, false))
        } else if (viewType == 1) {
            TweetView2Holder(layoutInflater.inflate(R.layout.rv_img, parent, false))
        } else {
            TweetView3Holder(layoutInflater.inflate(R.layout.rv_header, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return tweetList.size
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val item: Any = tweetList[position]
        holder.bind(item, position)
    }
}