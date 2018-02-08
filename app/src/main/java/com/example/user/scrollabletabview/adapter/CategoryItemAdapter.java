package com.example.user.scrollabletabview.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.scrollabletabview.R;
import com.example.user.scrollabletabview.model.masterCategoryModel.CategoryChild.ChildFromCategories;

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
    public View getView(final int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.row_categories_list,parent,false);
            viewHolder.serviceItemImageIV = (ImageView) view.findViewById(R.id.serviceItemImageIV);
            viewHolder.serviceItemTitleTV = (TextView) view.findViewById(R.id.serviceItemTitleTV);
            viewHolder.serviceItemPriceTV = (TextView) view.findViewById(R.id.serviceItemPriceTV);
            viewHolder.itemsCardView = (CardView) view.findViewById(R.id.itemsCardView);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.serviceItemTitleTV.setText(childFromCategories.get(position).getName());
//        if(childFromCategories.get(position).getStartingPrice()!=null){
//            viewHolder.serviceItemPriceTV.setText(childFromCategories.get(position).getStartingPrice());
//        }

        viewHolder.itemsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(childFromCategories.get(position)!=null){
                    Toast.makeText(context,""+childFromCategories.get(position).getName().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }

    static class ViewHolder{
        ImageView serviceItemImageIV;
        TextView serviceItemTitleTV;
        TextView serviceItemPriceTV;
        CardView itemsCardView;

    }
}
