package com.example.vix_schoters_annisaalqorina.model

import com.google.gson.annotations.SerializedName

data class DataNews(
    @SerializedName("articles")
    var articlesval : MutableList<Article>,

    @SerializedName("status")
    var status: String?,

    @SerializedName("totalResults")
    var  totalResults: Int?
)
