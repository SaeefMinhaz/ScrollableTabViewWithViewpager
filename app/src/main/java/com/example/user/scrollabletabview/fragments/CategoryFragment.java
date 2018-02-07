package com.example.user.scrollabletabview.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.user.scrollabletabview.R;
import com.example.user.scrollabletabview.adapter.CategoryItemAdapter;
import com.example.user.scrollabletabview.apiNetworking.ApiClient;
import com.example.user.scrollabletabview.apiNetworking.ApiService;
import com.example.user.scrollabletabview.model.masterCategoryModel.CategoryChild.ChildFromCategories;
import com.example.user.scrollabletabview.model.masterCategoryModel.CategoryChild.Secondary;
import com.example.user.scrollabletabview.model.masterCategoryModel.masterCategory.Child;
import com.example.user.scrollabletabview.model.masterCategoryModel.masterCategory.MasterCategory;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoryFragment extends Fragment {

    GridView categoryGridView;
    CategoryItemAdapter categoryItemAdapter;
    int childrenPosition;
    ApiClient apiClient;
    ArrayList<ChildFromCategories> childFromCategories;


    // newInstance constructor for creating fragment with arguments
//    public static CategoryFragment newInstance(int page, String title){
//            CategoryFragment oneFragment = new CategoryFragment();
//            Bundle args = new Bundle();
//            args.putInt("someInt", page);
//            args.putString("someTitle", title);
//            oneFragment.setArguments(args);
//
//            return oneFragment;
//    }

//    public static Fragment newInstance(int position) {
//        ArrayList<Category> categories;
//        CategoryFragment categoryFragment = new CategoryFragment();
//        Bundle args = new Bundle();
//        args.putInt("position", categories.get(position).getId());
//        categoryFragment.setArguments(args);
//        return categoryFragment;
//    }


    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        childrenPosition = getArguments().getInt("childPosition", 1);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        apiClient = ApiService.getClient().create(ApiClient.class);

        categoryGridView = (GridView) view.findViewById(R.id.categoryGridView);
//        categoryItemAdapter = new CategoryItemAdapter(children,getActivity());
//        categoryGridView.setAdapter(categoryItemAdapter);

        getChildView();
        return view;
    }

    private void getChildView() {
        Call<Secondary> call = apiClient.getChildFromMasterCategory(childrenPosition);
        call.enqueue(new Callback<Secondary>() {
            @Override
            public void onResponse(Call<Secondary> call, Response<Secondary> response) {
               if(response.isSuccessful()){
                   if (response.body().getCode()==200){
//                       Toast.makeText(getActivity()," "+ response.body().getCategoryofChild().getChildFromCategories(),Toast.LENGTH_SHORT).show();
                       childFromCategories = response.body().getCategoryofChild().getChildFromCategories();
                       categoryItemAdapter = new CategoryItemAdapter(childFromCategories,getActivity());
                       categoryGridView.setAdapter(categoryItemAdapter);
                   }else {
                       Toast.makeText(getActivity(),"Error Code "+ response.body().getCode(),Toast.LENGTH_SHORT).show();
                   }
               }else{
                   Toast.makeText(getActivity(),"Error Code "+ response.body().getCode(),Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            public void onFailure(Call<Secondary> call, Throwable t) {
                Toast.makeText(getActivity(),"Please try again",Toast.LENGTH_SHORT).show();
            }
        });
    }

//
}
