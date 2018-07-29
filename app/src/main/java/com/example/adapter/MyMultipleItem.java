package com.example.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.pojo.ZDYGoodsbean;

public class MyMultipleItem implements MultiItemEntity {
    public static final int TYPE_ONE  = 1;
    public static final int TYPE_TWO  = 2;

    private ZDYGoodsbean zdyGoodsbean;
    private int itemType;

    public MyMultipleItem(ZDYGoodsbean zdyGoodsbean, int itemType) {
        this.zdyGoodsbean = zdyGoodsbean;
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public ZDYGoodsbean getZdyGoodsbean() {
        return zdyGoodsbean;
    }
}
