package com.example.user.scrollabletabview.model.masterCategoryModel.CategoryChild;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by USER on 2/6/2018.
 */

public class CategoryofChild {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("banner")
    @Expose
    private String banner;
    @SerializedName("secondaries")
    @Expose
    private ArrayList<ChildFromCategories> childFromCategories = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public ArrayList<ChildFromCategories> getChildFromCategories() {
        return childFromCategories;
    }

    public void setChildFromCategories(ArrayList<ChildFromCategories> childFromCategories) {
        this.childFromCategories = childFromCategories;
    }
}
