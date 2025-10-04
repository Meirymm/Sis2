package com.example.sis2

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FeedViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val defaultPosts = listOf(
        Post(1, "\"Белгілі кәсіпкер \"Қайрат\" қақпашысы Шерхан Қалмұрзаға көлік сыйға тарту етті ", "https://cdn.nur.kz/images/1120x630/da321d3d2b82214c.webp?version=1"),
        Post(2, "Израиль Газаға бет алған бейбіт кемелерді тоқтатып, бес жүзге жуық белсендіні ұстады", "https://cdn.nur.kz/images/1120x630/d5a68afd3da4d9f3.webp?version=1"),
        Post(3, "Тимур Турлов пен Айдос Жұмағұлов мемлекет басшысына Freedom АІ-ассистент және қазақстандықтар үшін ChatGPT-дің толық тегін ңұсқасын ұсынды", "https://cdn.nur.kz/images/1120x630/37864f83fba331a2.webp?version=1"),
        Post(4, "\"\"Қайрат\" – \"Реал Мадрид\": Qazsport матч трансляциясы кезіндегі ақаудың себебін түсіндірді", "https://cdn.nur.kz/images/1120x630/2b3230f9d45cae7d.webp?version=1"),
        Post(5, "\"Үреймен өмір сүріп келеміз\": Алматыда егде жастағы тұрғынның әрекеті көршілерін шошытып отыр", "https://cdn.nur.kz/images/1120x630/fd8105557c87b619.webp?version=1"),
    )

    private val _posts = MutableStateFlow(
        savedStateHandle.get<List<Post>>("posts") ?: defaultPosts
    )

    val posts: StateFlow<List<Post>> = _posts

    fun toggleLike(postId: Int) {
        val updatedPosts = _posts.value.map { post ->
            if (post.id == postId) post.copy(isLiked = !post.isLiked) else post
        }
        _posts.value = updatedPosts
        savedStateHandle["posts"] = updatedPosts
    }

}

