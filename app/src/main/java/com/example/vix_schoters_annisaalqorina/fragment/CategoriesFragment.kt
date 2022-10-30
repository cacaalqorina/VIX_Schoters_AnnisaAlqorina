package com.example.vix_schoters_annisaalqorina.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vix_schoters_annisaalqorina.R
import com.example.vix_schoters_annisaalqorina.databinding.FragmentCategoriesBinding
import java.io.Serializable


class CategoriesFragment : Fragment(), Serializable, View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding: FragmentCategoriesBinding =
            FragmentCategoriesBinding.inflate(inflater, container, false)
        binding.genralCategory.setOnClickListener(this)
        binding.sportsCategory.setOnClickListener(this)
        binding.technologyCategory.setOnClickListener(this)
        binding.healthCategity.setOnClickListener(this)
        binding.scienceCategory.setOnClickListener(this)
        binding.businessCategory.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.sports_category -> {
                    showcategoryNews("sports")
                }
                R.id.technology_category -> {
                    showcategoryNews("technology")
                }
                R.id.business_category -> {
                    showcategoryNews("business")
                }
                R.id.genral_category -> {
                    showcategoryNews("general")
                }
                R.id.health_categity -> {
                    showcategoryNews("health")
                }
                R.id.science_category -> {
                    showcategoryNews("science")
                }
            }
        }
    }

    private fun showcategoryNews(category: String) {

        var newsFragment = NewsFragment()
        var bundle = Bundle()
        bundle.putString("fragmentName", resources.getString(R.string.category))
        bundle.putString("category", category)
        newsFragment.arguments = bundle

        activity?.supportFragmentManager?.beginTransaction()?.addToBackStack("ss")
            ?.replace(R.id.main_FrameL, newsFragment)
            ?.commit()
    }

}