package com.example.vix_schoters_annisaalqorina.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vix_schoters_annisaalqorina.model.Article
import com.example.vix_schoters_annisaalqorina.model.DataNews
import com.example.vix_schoters_annisaalqorina.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelNews (val newsRepository: NewsRepository): ViewModel() {

    var mutableLiveData: MutableLiveData<DataNews> = MutableLiveData()
    var articleMutableLiveData: MutableLiveData<MutableList<Article>> = MutableLiveData()

    fun getNews(
        countryCode: String?,
        pageNumber: Int,
        category: String?
    ){
        viewModelScope.launch(Dispatchers.IO){
            mutableLiveData.postValue(newsRepository.getNews(countryCode, pageNumber, category))
        }
    }

    fun searchNews(
        keyword: String?,
        language: String?,
        sortedBy: String,
        maxResults: String
    ){
        viewModelScope.launch(Dispatchers.IO){
            mutableLiveData.postValue(newsRepository.searchNews(keyword, language, sortedBy, maxResults))
        }
    }

    fun insertArticle(
        context: Context,
        article: Article
    ){
        viewModelScope.launch(Dispatchers.IO){
            newsRepository.insertArticle(article)
        }
    }

    fun getSavedArticle(){
        viewModelScope.launch(Dispatchers.IO){
            articleMutableLiveData.postValue(newsRepository.getSavedArticle())
        }
    }

    fun deletedArticle(
        articleUrl: String
    ){
        viewModelScope.launch(Dispatchers.IO){
            newsRepository.deletedArticle(articleUrl)
        }
    }
}