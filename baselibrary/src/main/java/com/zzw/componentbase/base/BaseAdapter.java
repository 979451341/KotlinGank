package com.zzw.componentbase.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * 创建人: xieyushang
 * 时间: 2017-12-19 10:34
 */

public abstract class BaseAdapter<T , K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {

    public BaseAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public BaseAdapter(@Nullable List<T> data) {
        super(data);
    }

    public BaseAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected K createBaseViewHolder(View view) {
        AutoUtils.auto(view);
        return super.createBaseViewHolder(view);
    }

}
