package com.example.vix_schoters_annisaalqorina.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.vix_schoters_annisaalqorina.repository.NewsRepository

class ViewModelFactoryNews(val newsRepository: NewsRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelNews(newsRepository) as T
    }
}