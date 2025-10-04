package com.example.sis2

data class Post(
    val id: Int,
    val text: String,
    val imageUrl: String,
    val isLiked: Boolean = false
)
