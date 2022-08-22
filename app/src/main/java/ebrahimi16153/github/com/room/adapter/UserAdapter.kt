package ebrahimi16153.github.com.room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ebrahimi16153.github.com.room.databinding.UserListItemBinding
import ebrahimi16153.github.com.room.db.UserEntity

class UserAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            UserListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setViews(diff.currentList[position])
    }

    override fun getItemCount() =diff.currentList.size

    inner class ViewHolder(private val binding: UserListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setViews(item: UserEntity) {
            binding.nameItem.text = item.userName
            binding.ageItem.text = item.userAge.toString()
        }


    }

    private val diffCalBack = object : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }

    }

    val diff = AsyncListDiffer(this,diffCalBack)


}