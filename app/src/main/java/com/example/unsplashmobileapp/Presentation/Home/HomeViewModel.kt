package com.example.unsplashmobileapp.Presentation.Home

import androidx.lifecycle.ViewModel
import com.example.unsplashmobileapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {
    val getAllImages = repository.getAllImages()
}
