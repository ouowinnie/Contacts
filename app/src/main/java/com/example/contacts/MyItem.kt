package com.example.contacts

data class MyItem(val profile: Int, val name: String, val number: String, var isFavorite: Boolean) {
    fun toggleFavorite() {
        isFavorite = !isFavorite
    }
}
