package com.example.vix_schoters_annisaalqorina.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vix_schoters_annisaalqorina.R
import com.example.vix_schoters_annisaalqorina.adapter.MainActivity
import com.example.vix_schoters_annisaalqorina.adapter.NewsAdapter
import com.example.vix_schoters_annisaalqorina.databinding.FragmentFavouriteBinding
import com.example.vix_schoters_annisaalqorina.util.shareNews
import com.example.vix_schoters_annisaalqorina.viewmodel.ViewModelNews


class FavouriteFragment : Fragment() {
    lateinit var viewModelNews: ViewModelNews

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding: FragmentFavouriteBinding =
            FragmentFavouriteBinding.inflate(inflater, container, false)
        viewModelNews = (activity as MainActivity).viewModelNews
        var newsAdapter = NewsAdapter()
        viewModelNews.articleMutableLiveData.observe(viewLifecycleOwner) {
            if (newsAdapter != null) {
                newsAdapter.differ.submitList(it)
            }
        }
        handleClicks(newsAdapter)
        viewModelNews.getSavedArticle()
        binding.favRecycler.adapter = newsAdapter
        binding.favRecycler.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    private fun handleClicks(newsAdapter: NewsAdapter) {
        newsAdapter.setOnShowMoreListener {
            var displayFragment = DisplayNewsFragment()
            var bundle = Bundle()
            bundle.putSerializable("article", it)
            displayFragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack("")
                ?.replace(R.id.main_FrameL, displayFragment)?.commit()
        }

        newsAdapter.onSaveNewsClickListener {
            context?.let { it1 -> viewModelNews.insertArticle(it1, it) }
        }
        newsAdapter.onDeleteClickListener {
            it.url?.let { it1 ->viewModelNews.deletedArticle(it1) }
        }
        newsAdapter.onShareClickListener {
            shareNews((activity as MainActivity), it)
        }


    }
}