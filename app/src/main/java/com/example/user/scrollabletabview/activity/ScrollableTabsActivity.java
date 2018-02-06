package com.example.user.scrollabletabview.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.example.user.scrollabletabview.R;
import com.example.user.scrollabletabview.adapter.ViewPagerAdapter;
import com.example.user.scrollabletabview.apiNetworking.ApiClient;
import com.example.user.scrollabletabview.apiNetworking.ApiService;
import com.example.user.scrollabletabview.model.masterCategoryModel.masterCategory.Category;
import com.example.user.scrollabletabview.model.masterCategoryModel.masterCategory.MasterCategory;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapterViewPager;
    ArrayList<MasterCategory> masterCategories;
    ArrayList<Category> categories;
    ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        apiClient = ApiService.getClient().create(ApiClient.class);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        setupViewPager(viewPager);
//        adapterViewPager = new ViewPagerAdapter(getSupportFragmentManager(), masterCategories);
//        viewPager.setAdapter(adapterViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        getAPIMasterCategory();
    }

    private void getAPIMasterCategory() {
        Call<MasterCategory> call = apiClient.getMasterCategoryApiResponse("children");
        call.enqueue(new Callback<MasterCategory>() {
            @Override
            public void onResponse(Call<MasterCategory> call, Response<MasterCategory> response) {
                if (response.isSuccessful()){
                    if (response.body().getCode()==200){
                        Toast.makeText(ScrollableTabsActivity.this,"Total Master Category size "+response.body().getCategories().size()
                                ,Toast.LENGTH_SHORT).show();

                        categories = response.body().getCategories();
                        Log.w("categories","res"+masterCategories);

                        adapterViewPager = new ViewPagerAdapter(getSupportFragmentManager(), categories);
                        viewPager.setAdapter(adapterViewPager);

                    } else {
                        Toast.makeText(ScrollableTabsActivity.this,"response code "+response.body().getCode()
                                ,Toast.LENGTH_SHORT).show();


                    }

                } else {
                    Toast.makeText(ScrollableTabsActivity.this,"Error Code "+ response.body().getCode(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MasterCategory> call, Throwable t) {
                Toast.makeText(ScrollableTabsActivity.this,"please try again",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
