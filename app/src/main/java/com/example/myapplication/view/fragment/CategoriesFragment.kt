package com.example.myapplication.view.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.CategoryFragmentBinding
import com.example.myapplication.model.CategoriesItem
import com.example.myapplication.model.RankingsItem
import com.example.myapplication.utilities.ApplicationConstants
import com.example.myapplication.view.adapters.CategoryFragmentAdapter
import com.example.myapplication.view.adapters.RankingFragmentAdapter

class CategoriesFragment: Fragment() {

    var databinding: CategoryFragmentBinding? = null
    var categoriesItemModel: CategoriesItem? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        databinding = DataBindingUtil.inflate(inflater, R.layout.category_fragment, container, false)
        categoriesItemModel = arguments?.getSerializable(ApplicationConstants.TYPE_CATEGORY_ITEM) as CategoriesItem
        return databinding?.root
    }

    override fun onResume() {
        super.onResume()
        categoriesItemModel?.let {
            var categoryAdapter = CategoryFragmentAdapter(requireContext(), categoriesItemModel!!)
            databinding?.categoryHolderRecycler?.layoutManager = LinearLayoutManager(requireContext())
            databinding?.categoryHolderRecycler?.adapter = categoryAdapter
        }
    }
}