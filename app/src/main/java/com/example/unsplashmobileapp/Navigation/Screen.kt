package com.example.unsplashmobileapp.Navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Search : Screen("search")
}
