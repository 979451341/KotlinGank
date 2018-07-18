package com.example.lilingzhi.mygank

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.lilingzhi.mygank.adapter.MainViewPageAdapter
import com.example.lilingzhi.mygank.fragment.AndroidFragment
import com.zzw.componentbase.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        val allFm=AndroidFragment()
        allFm.title=titles[0]
        val welfareFm=AndroidFragment()
        welfareFm.title=titles[1]
        val androidFm=AndroidFragment()
        androidFm.title=titles[2]
        val iOSFm=AndroidFragment()
        iOSFm.title=titles[3]
        val restFm=AndroidFragment()
        restFm.title=titles[4]
        val expandFm=AndroidFragment()
        expandFm.title=titles[5]
        val frondFm=AndroidFragment()
        frondFm.title=titles[6]
        fmList= arrayListOf(allFm,welfareFm,androidFm,iOSFm,restFm,expandFm,frondFm)

        vpadapter= MainViewPageAdapter(supportFragmentManager,titles,fmList)
        vp.adapter=vpadapter
        tl.setupWithViewPager(vp)
        tl.setTabsFromPagerAdapter(vpadapter)



    }

    override fun initData() {

    }

    var  titles:List<String> = arrayListOf("all","福利","Android","iOS","休息视频","拓展资源","前端")
    lateinit var fmList:List<Fragment>

    lateinit var vpadapter:MainViewPageAdapter


}
