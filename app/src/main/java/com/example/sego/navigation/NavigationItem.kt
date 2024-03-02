package com.example.sego.navigation


data class NavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
    val badgeCount: Int? = null
)