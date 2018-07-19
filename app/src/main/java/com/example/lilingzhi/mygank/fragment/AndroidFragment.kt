package com.example.lilingzhi.mygank.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lilingzhi.mygank.MainActivity
import com.example.lilingzhi.mygank.R
import com.example.lilingzhi.mygank.adapter.AndroidAdapter
import com.example.lilingzhi.mygank.bean.BaseBean
import com.example.lilingzhi.mygank.bean.DataBean
import com.example.lilingzhi.mygank.net.JsonCallBack
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.zzw.componentbase.base.BaseFragment
import com.zzw.componentbase.interfaces.EndLessOnScrollListener
import com.zzw.componentbase.utils.ToastUtils

class AndroidFragment():BaseFragment(){

    var sum:Int=10
    var page:Int=1

    lateinit var layotManager:LinearLayoutManager
    lateinit var adapter:AndroidAdapter
    var dataList:MutableList<DataBean> = mutableListOf();

    lateinit var myview:View

    override fun initViews(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {


        myview=inflater!!.inflate(R.layout.fragment_base,container, false)

        return myview
    }

    override fun initData() {
        layotManager= LinearLayoutManager(activity)
        layotManager.orientation=LinearLayoutManager.VERTICAL
        var recyc = myview.findViewById<RecyclerView>(R.id.recyc)
        recyc.layoutManager=layotManager
        if(title.equals("福利")){
            adapter= AndroidAdapter(R.layout.item_base,dataList,1);
        }else{
            adapter= AndroidAdapter(R.layout.item_base,dataList,0);
        }
        recyc.adapter=adapter

        recyc.addOnScrollListener(object :EndLessOnScrollListener(layotManager){
            override fun onLoadMore(currentPage: Int) {
                getData()
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    Glide.with(activity).resumeRequests()
                }else{
                    Glide.with(activity).pauseRequests()
                }
            }
        })

        getData()



    }

    override fun setDefaultFragmentTitle(title: String?) {

    }

    fun getData(){

        OkGo.get<BaseBean>("http://gank.io/api/data/"+title+"/"+sum+"/"+page)
                .tag(this)
                .execute(object : JsonCallBack<BaseBean>(){
                    override fun onSuccess(response: Response<BaseBean>) {
                        super.onSuccess(response)

                        var i:Iterator<DataBean> = response?.body()!!.results.iterator()

                        while (i.hasNext()){
                            dataList.add(i.next())
                        }
                        adapter.notifyDataSetChanged()

                        Log.v("zzw",""+dataList.size)
                        page++

                        ToastUtils.showToast(activity,"数据加载成功！")

                    }

                    override fun onError(response: Response<BaseBean>) {
                        super.onError(response)

                    }
                })
    }
    override fun onDestroy() {
        super.onDestroy()
        OkGo.getInstance().cancelTag(this)
    }


}
