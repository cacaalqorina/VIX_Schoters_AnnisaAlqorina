package com.example.vix_schoters_annisaalqorina.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import javax.xml.transform.Source

@Entity(
    tableName = "articles", indices = [Index(value = ["url"], unique = true)]
)

data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @SerializedName("author")
    var author: String?,

    @SerializedName("content")
    var content: String?,

    @SerializedName("description")
    var description: String?,

    @SerializedName("publishedAt")
    var publishedAt: String?,

    @SerializedName("source")
    var source: Source?,

    @SerializedName("tittle")
    var tittle: String?,

    @SerializedName("url")
    var url: String?,

    @SerializedName("urlToImage")
    var urlToImage: String?,

    @SerializedName("isFavorite")
    var isFavorite: Boolean = false
): java.io.Serializable
