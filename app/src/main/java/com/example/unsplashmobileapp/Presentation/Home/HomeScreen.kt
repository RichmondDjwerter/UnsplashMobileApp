package com.example.unsplashmobileapp.Presentation.Home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.unsplashmobileapp.Navigation.Screen
import com.example.unsplashmobileapp.Presentation.Common.ListContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()

    Scaffold(topBar = {
        HomeTopBar(
            onSearchClicked = {
                navController.navigate(Screen.Search.route)
            }
        )
    }, content = {
        ListContent(items = getAllImages)
    })
}