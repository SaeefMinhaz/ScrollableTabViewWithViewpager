package com.example.user.scrollabletabview.model.masterCategoryModel.CategoryChild;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 2/6/2018.
 */

public class Secondary {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("category")
    @Expose
    private CategoryofChild categoryofChild;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public CategoryofChild getCategoryofChild() {
        return categoryofChild;
    }

    public void setCategoryofChild(CategoryofChild categoryofChild) {
        this.categoryofChild = categoryofChild;
    }
}
