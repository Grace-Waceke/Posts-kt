package dev.waceke.mypost

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.waceke.mypost.databinding.ActivityCommentBinding
import dev.waceke.mypost.databinding.CommentListBinding
import dev.waceke.mypost.databinding.DisplayPostItemBinding



class commentRVAdapter( var currentList: List<Comment>): RecyclerView.Adapter<commentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commentViewHolder {
        var binding = ActivityCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return commentViewHolder(binding)

    }

    override fun onBindViewHolder(holder: commentViewHolder, position: Int) {
        var currentComment= currentList .get(position)
//        holder.bindingView.tvPostTitle.text = currentComment.title
//        holder.bindingView.tvPostBody.text = currentComment.body
//        val context = holder.itemView.context

        with(holder.bindingView){
            tvPostTitle.text =currentComment.body
            tvPostBody.text=currentComment.title
        }
    }

    override fun getItemCount(): Int {
        return currentList.size


    }
}
class commentViewHolder(var bindingView: ActivityCommentBinding):
    RecyclerView.ViewHolder(bindingView.root){

    }







