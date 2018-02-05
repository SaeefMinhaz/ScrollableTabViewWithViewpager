package com.example.user.scrollabletabview.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.scrollabletabview.R;


public class OneFragment extends Fragment {

    private String title;
    private int page;
    TextView pageTitleTV;

    // newInstance constructor for creating fragment with arguments
    public static OneFragment newInstance(int page, String title){
            OneFragment oneFragment = new OneFragment();
            Bundle args = new Bundle();
            args.putInt("someInt", page);
            args.putString("someTitle", title);
            oneFragment.setArguments(args);

            return oneFragment;
    }


    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);
        pageTitleTV = (TextView) view.findViewById(R.id.pageTitleTV);
        pageTitleTV.setText(page + "" + title);

        return view;
    }

}
