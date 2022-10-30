package com.example.vix_schoters_annisaalqorina.repository

import com.example.vix_schoters_annisaalqorina.database.NewsDataBase
import com.example.vix_schoters_annisaalqorina.model.Article
import com.example.vix_schoters_annisaalqorina.model.DataNews
import com.example.vix_schoters_annisaalqorina.service.RetrofitInstance
import com.example.vix_schoters_annisaalqorina.util.Constants

class NewsRepository (val db: NewsDataBase){
    suspend fun getNews(countryCode: String?, pageNumber: Int,
    category: String?): DataNews?{
        var response =
            RetrofitInstance.api.getTopNews(
                countryCode, pageNumber, category,
                Constants.API_KEY
            )
        return if (response.isSuccessful){
            response.body()
        } else {
            null
        }
    }

    suspend fun searchNews(
        keyword: String?,
        language: String?,
        sortedBy: String,
        maxResults: String
    ): DataNews? {
        var response =
            RetrofitInstance.api.searchNews(
                keyword, sortedBy, Constants.API_KEY,
                language, maxResults
            )
        return if (response.isSuccessful){
            response.body()
        }else{
            null
        }
    }

    fun insertArticle(article: Article){
        db.NewsDao().insert(article)
    }

    fun getSavedArticle(): MutableList<Article>{
        return db.NewsDao().getArticles()
    }

    fun deletedArticle(articleUrl: String){
        db.NewsDao().deleteArticle(articleUrl)
    }
}