import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewapp.R
import kotlinx.android.synthetic.main.rv_list_item.view.*

class TweetAdapter : RecyclerView.Adapter<TweetAdapter.TweetViewHolder>(){
    var tweetList: ArrayList<String> = ArrayList()


    fun setItems(item : ArrayList<String>){
        this.tweetList = item
    }

    class TweetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card = itemView.tv_list_item
        fun bind(str: String,  position: Int){
            card.text = str
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TweetViewHolder(layoutInflater.inflate(R.layout.rv_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return tweetList.size
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val item = tweetList[position]
        holder.bind(item, position)
    }
}