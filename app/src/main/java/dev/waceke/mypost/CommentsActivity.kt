package dev.waceke.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.waceke.mypost.databinding.ActivityCommentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId = 0
    lateinit var binding:ActivityCommentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPost()
        fetchPostById()
        fetchComment()
    }

    fun obtainPost(){
        postId = intent.extras?.getInt("POST_ID")?: 0
    }
    fun fetchPostById(){
        val apiClient = ApiClient.buildApiClient((ApiInterface::class.java))
        val request = apiClient.getPostsById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post = response.body()
                    binding.tvPostBody.text = post?.body
                    binding.tvPostTitle.text = post?.title

                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }
    fun fetchComment(){
        val apiClient = ApiClient.buildApiClient((ApiInterface::class.java))
        val request = apiClient.getCommentId()
        request.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if (response.isSuccessful){
                    var comment=response.body()
                    if (comment != null)
                        displaycomment(comment)

                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                val baseContext = null
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

            }
        })

    }
    fun displaycomment(commentList: List<Comment>) {
        binding.rvComments.layoutManager = LinearLayoutManager(this)
        var commentRvAdapter = commentRVAdapter(commentList)
        binding.rvComments.adapter = commentRvAdapter
    }
}