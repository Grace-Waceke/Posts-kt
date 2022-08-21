package dev.waceke.mypost

import android.security.identity.AccessControlProfileId
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>
    @GET("/posts/{postId}")
    fun getPostsById(@Path("postId")postId: Int): Call<Post>
    @GET("/posts/{Id}/comments")


    fun getCommentId(@Path("commentId")commentId: Int): Call<List<Comment>>
}