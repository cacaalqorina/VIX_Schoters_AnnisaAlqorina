package com.example.vix_schoters_annisaalqorina.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.example.vix_schoters_annisaalqorina.R
import com.example.vix_schoters_annisaalqorina.databinding.FragmentDisplayNewsBinding
import com.example.vix_schoters_annisaalqorina.model.Article


class DisplayNewsFragment : Fragment() {
    lateinit var binding: FragmentDisplayNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDisplayNewsBinding.inflate(inflater, container, false)
        displayNews(arguments)
        return binding.root
    }

    private fun displayNews(arguments: Bundle?) {
        if (arguments != null) {
            var news: Article = arguments.getSerializable("article") as Article

            binding.webView.apply {
                webViewClient = WebViewClient()
                news.url?.let { loadUrl(it) }
            }

        }

    }


}