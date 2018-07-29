package com.example.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.activivty.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyGoodsCarAdapter extends BaseMultiItemQuickAdapter<MyMultipleItem,BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MyGoodsCarAdapter(List<MyMultipleItem> data) {
        super(data);
        addItemType(MyMultipleItem.TYPE_ONE, R.layout.item_shop0);
        addItemType(MyMultipleItem.TYPE_TWO, R.layout.item_shop);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyMultipleItem item) {
        switch (helper.getItemViewType()){
            case MyMultipleItem.TYPE_ONE:
                helper.setText(R.id.item_tv_good_title,item.getZdyGoodsbean().getTitle())
                        .setText(R.id.item_tv_good_weight,item.getZdyGoodsbean().getBargainPrice()+"")
                        .setText(R.id.item_tv_goods_price,item.getZdyGoodsbean().getPid())
                        .setText(R.id.item_tv_goodsNum,item.getZdyGoodsbean().getNum()+"")
                        .addOnClickListener(R.id.item_iv_seletor)
                        .addOnClickListener(R.id.item_iv_goodsAdd)
                        .addOnClickListener(R.id.item_iv_seletorchild)
                        .addOnClickListener(R.id.item_iv_jian);
                Picasso.get().load(item.getZdyGoodsbean().getImages().split("[|]")[0]).into((ImageView) helper.getView(R.id.item_iv_goods_icon));
                if (item.getZdyGoodsbean().getSelected().equals("0")){
                    Picasso.get().load(R.drawable.select_false).into((ImageView) helper.getView(R.id.item_iv_seletorchild));
                }else {
                    Picasso.get().load(R.drawable._select_true).into((ImageView) helper.getView(R.id.item_iv_seletorchild));
                }
                break;
            case MyMultipleItem.TYPE_TWO:
                helper.setText(R.id.item_tv_good_title,item.getZdyGoodsbean().getTitle())
                        .setText(R.id.item_tv_good_weight,item.getZdyGoodsbean().getBargainPrice()+"")
                        .setText(R.id.item_tv_shop_name,item.getZdyGoodsbean().getSellerName())
                        .setText(R.id.item_tv_goods_price,item.getZdyGoodsbean().getPid())
                        .setText(R.id.item_tv_goodsNum,item.getZdyGoodsbean().getNum()+"")
                        .addOnClickListener(R.id.item_iv_seletor)
                        .addOnClickListener(R.id.item_iv_goodsAdd)
                        .addOnClickListener(R.id.item_iv_seletorchild)
                        .addOnClickListener(R.id.item_iv_jian);
                Picasso.get().load(item.getZdyGoodsbean().getImages().split("[|]")[0]).into((ImageView) helper.getView(R.id.item_iv_goods_icon));
                if (!item.getZdyGoodsbean().isSelectedchild()){
                    Picasso.get().load(R.drawable.select_false).into((ImageView) helper.getView(R.id.item_iv_seletor));
                }else {
                    Picasso.get().load(R.drawable._select_true).into((ImageView) helper.getView(R.id.item_iv_seletor));
                }
                if (item.getZdyGoodsbean().getSelected().equals("0")){
                    Picasso.get().load(R.drawable.select_false).into((ImageView) helper.getView(R.id.item_iv_seletorchild));
                }else {
                    Picasso.get().load(R.drawable._select_true).into((ImageView) helper.getView(R.id.item_iv_seletorchild));
                }
                break;
        }
    }
}
