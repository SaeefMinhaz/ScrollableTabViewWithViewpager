package com.example.user.scrollabletabview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.scrollabletabview.R;
import com.example.user.scrollabletabview.model.masterCategoryModel.CategoryChild.ChildFromCategories;
import com.example.user.scrollabletabview.model.masterCategoryModel.masterCategory.Child;

import java.util.ArrayList;

/**
 * Created by SHOVON on 2/6/2018.
 */

public class CategoryItemAdapter extends BaseAdapter{

    private LayoutInflater layoutInflater;
    private ArrayList<ChildFromCategories> childFromCategories;
    private Context context;

    public CategoryItemAdapter(ArrayList<ChildFromCategories> childFromCategories, Context context) {
        this.context = context;
//      this.layoutInflater = layoutInflater;
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.childFromCategories = childFromCategories;
    }

    @Override
    public int getCount() {
        return childFromCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.row_categories_list,parent,false);
            viewHolder.serviceItemImageIV = (ImageView) view.findViewById(R.id.serviceItemImageIV);
            viewHolder.serviceItemTitleTV = (TextView) view.findViewById(R.id.serviceItemTitleTV);
            viewHolder.serviceItemPriceTV = (TextView) view.findViewById(R.id.serviceItemPriceTV);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.serviceItemTitleTV.setText(childFromCategories.get(position).getName());
        viewHolder.serviceItemPriceTV.setText(childFromCategories.get(position).getStartingPrice());

        return view;
    }

    static class ViewHolder{
        ImageView serviceItemImageIV;
        TextView serviceItemTitleTV;
        TextView serviceItemPriceTV;

    }
}
