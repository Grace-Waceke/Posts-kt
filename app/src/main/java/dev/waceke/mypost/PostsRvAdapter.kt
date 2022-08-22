package dev.waceke.mypost

import android.content.Context
import android.content.Intent
import android.view.Display
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import dev.waceke.mypost.databinding.ActivityMainBinding
import dev.waceke.mypost.databinding.DisplayPostItemBinding

class PostsRvAdapter( var postList: List<Post>): RecyclerView.Adapter<RetrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var binding =DisplayPostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RetrofitViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var Currentposts = postList.get(position)
//        holder.bindingView.tvUserId.text = Currentposts.userId.toString()
//        holder.bindingView.tvId.text = Currentposts.id.toString()
//        holder.bindingView.tvTitle.text = Currentposts.title
//        holder.bindingView.tvBody.text = Currentposts.body
//        var context = holder.itemView.context
//        holder.bindingView.cvPosts.setOnClickListener {
//            val intent = Intent(context,CommentActivity::class.java)
//            intent.putExtra("POST_ID",Currentposts.id)
//            context.startActivity(intent)
//        }
        holder.bindingView.tvTitle.text = Currentposts.title
        holder.bindingView.tvBody.text =Currentposts.body
        holder.bindingView.tvUserId.text = Currentposts.title
        holder.bindingView.tvId.text =Currentposts.body
        val context =holder.itemView.context
        holder.bindingView.cvPosts.setOnClickListener{
            val  intent =Intent(context,CommentsActivity::class.java)
            intent.putExtra("POST_ID", Currentposts.id)
            context.startActivity(intent)

        }
//        with(holder.bindingView){
//            tvTitle.text =Currentposts.body
//            tvBody.text=Currentposts.title
//        }
    }

    override fun getItemCount(): Int {
        return postList.size

    }
}
class RetrofitViewHolder(val bindingView: DisplayPostItemBinding):
    RecyclerView.ViewHolder(bindingView.root){

}