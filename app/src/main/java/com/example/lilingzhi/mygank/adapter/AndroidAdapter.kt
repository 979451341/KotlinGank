package com.example.lilingzhi.mygank.adapter

import android.content.Intent
import android.support.v7.widget.CardView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.lilingzhi.mygank.R
import com.example.lilingzhi.mygank.WebActivity
import com.example.lilingzhi.mygank.bean.DataBean
import kotlinx.android.synthetic.main.item_base.view.*
import com.zhy.autolayout.utils.AutoUtils



class AndroidAdapter(var layoutId:Int, var dataLis:List<DataBean>,var sort:Int):BaseQuickAdapter<DataBean,BaseViewHolder>(layoutId,dataLis){



    override fun convert(helper: BaseViewHolder?, item: DataBean?) {



        helper!!.setText(R.id.tv_title,item?.desc)
                .setText(R.id.tv_name,item?.who)

        if (item?.images!=null&&item?.images.size>=1) {
            Glide.with(mContext).load(item.images[0]).into(helper.getView(R.id.iv))
        }else{
            if(sort==1){
                Glide.with(mContext).load(item!!.url).into(helper.getView(R.id.iv))
            }
        }
        if(sort!=1){
            helper.getView<CardView>(R.id.cv).setOnClickListener{
                var intent: Intent =Intent(mContext,WebActivity::class.java);
                intent.putExtra("url",item!!.url)
                mContext.startActivity(intent)
            }

        }else{


        }

    }

    override fun onViewRecycled(holder: BaseViewHolder) {
        if(holder!=null){
            Glide.clear(holder.getView<ImageView>(R.id.iv))
        }
        super.onViewRecycled(holder)

    }

    override fun createBaseViewHolder(view: View?): BaseViewHolder {
        AutoUtils.autoSize(view)
        return super.createBaseViewHolder(view)
    }


}