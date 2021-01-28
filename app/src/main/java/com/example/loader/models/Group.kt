package com.example.loader.models

data class Group(
    val badge: Badge,
    val id: String,
    val items: List<Item>,
    val link: String,
    val title: String
)