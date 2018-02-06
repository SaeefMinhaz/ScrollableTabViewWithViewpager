package com.example.user.scrollabletabview.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.scrollabletabview.fragments.CategoryFragment;
import com.example.user.scrollabletabview.model.masterCategoryModel.masterCategory.Category;


import java.util.ArrayList;

/**
 * Created by SHOVON on 2/4/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Category> masterCategories;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Category> masterCategories) {
        super(fm);
        this.masterCategories = masterCategories;
    }

    @Override
    public int getCount() {
        return this.masterCategories.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        CategoryFragment categoryFragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt("childPosition", masterCategories.get(position).getId());
        categoryFragment.setArguments(args);
        return categoryFragment;
    }


//    @Override
//    public Fragment getItem(int position) {
//        return CategoryFragment.newInstance(position);
//    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return masterCategories.get(position).getName();
    }
}