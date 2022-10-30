package com.example.vix_schoters_annisaalqorina.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vix_schoters_annisaalqorina.model.Article

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getArticles(): MutableList<Article>

    @Query("DELETE FROM articles WHERE url = :articleUrl")
    fun deleteArticle(articleUrl: String)
}