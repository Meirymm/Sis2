package com.example.sis2

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FeedViewModel(private val state: SavedStateHandle) : ViewModel() {

    companion object {
        private const val KEY_POSTS = "posts"
    }

    private val _posts = MutableStateFlow(state.get<List<Post>>(KEY_POSTS) ?: generateMockPosts())
    val posts: StateFlow<List<Post>> = _posts

    fun toggleLike(postId: Int) {
        val updated = _posts.value.map {
            if (it.id == postId) it.copy(isLiked = !it.isLiked) else it
        }
        _posts.value = updated
        state.set(KEY_POSTS, updated)
    }

    private fun generateMockPosts(): List<Post> {
        return listOf(
            Post(1, "First Compose Post", "https://i.pinimg.com/originals/4a/ba/f3/4abaf352645fd2142ed6555f789e0a2e.jpg"),
            Post(2, "Second News Item", "https://cs6.pikabu.ru/post_img/big/2015/04/26/6/1430037626_1786129976.jpg"),
            Post(3, "Kotlin ❤️ Compose", "https://wallpapers.com/images/hd/beautiful-sunset-pictures-ubxtuvfhpoampb6d.jpg")
        )
    }
}
