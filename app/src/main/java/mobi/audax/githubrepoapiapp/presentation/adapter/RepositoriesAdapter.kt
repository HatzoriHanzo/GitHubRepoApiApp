package mobi.audax.githubrepoapiapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.repository_preview.view.*
import mobi.audax.githubrepoapiapp.R
import mobi.audax.githubrepoapiapp.data.model.Item

class RepositoriesAdapter : RecyclerView.Adapter<RepositoriesAdapter.RepositoryViewHolder>() {
    inner class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.htmlUrl == newItem.htmlUrl
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
      return RepositoryViewHolder(
          LayoutInflater.from(parent.context).inflate(R.layout.repository_preview,parent,false)
      )
    }
    override fun getItemCount(): Int = differ.currentList.size

    private var onItemClickListener: ((Item) -> Unit)? = null

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(repository.owner.avatar_url).into(ivRepositoryThumbnail)
            tvAuthor.text = repository.owner.login
            tvName.text = repository.name

            setOnClickListener {
                onItemClickListener?.let { it(repository) }
            }
        }
    }
    fun setOnItemClickListener(listener: (Item) -> Unit) {
        onItemClickListener = listener
    }



}