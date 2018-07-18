package com.example.lilingzhi.mygank.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MainViewPageAdapter(var fm:FragmentManager, var titleList:List<String>, var fmList:List<Fragment>)
    :FragmentPagerAdapter(fm){

    lateinit var titles:List<String>;
    lateinit var fms:List<Fragment>;

    init {
        this.titles=titleList
        this.fms=fmList
    }

    override fun getItem(position: Int): Fragment {
        return fms.get(position)
    }

    override fun getCount(): Int {
        return fms.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList.get(position)
    }














}