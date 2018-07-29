package com.example.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.activivty.R;
import com.example.pojo.GoodsBean;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class MyMutilAdapter extends BaseQuickAdapter<GoodsBean.DataBean,BaseViewHolder> {

    public MyMutilAdapter(int layoutResId, @Nullable List<GoodsBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsBean.DataBean item) {
        helper.setText(R.id.item_tv_good_title,item.getTitle())
                .setText(R.id.item_tv_good_barginprice,item.getBargainPrice())
                .setText(R.id.item_tv_goods_price,item.getPrice());
        Glide.with(mContext)
                .load(item.getImages().split("[|]")[0])
                .apply(bitmapTransform(new RoundedCornersTransformation(20,20)))
                .into((ImageView) helper.getView(R.id.item_iv_goods_icon));
    }
}
