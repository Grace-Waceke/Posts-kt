package dev.waceke.mypost

import android.content.Context
import android.view.Display
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import dev.waceke.mypost.databinding.ActivityMainBinding
import dev.waceke.mypost.databinding.DisplayPostItemBinding

class PostsRvAdapter(var Context:Context, var posts:List<Post>):
RecyclerView.Adapter<RetrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding = DisplayPostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var Currentposts = posts.get(position)
        holder.binding.tvUserId.text = Currentposts.userId.toString()
        holder.binding.tvId.text = Currentposts.id.toString()
        holder.binding.tvTitle.text = Currentposts.title
        holder.binding.tvBody.text = Currentposts.body




    }

    override fun getItemCount(): Int {
        return posts.size

    }
}
class RetrofitViewHolder(val binding: DisplayPostItemBinding): RecyclerView.ViewHolder(binding.root)