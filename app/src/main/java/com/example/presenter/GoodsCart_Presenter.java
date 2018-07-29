package com.example.presenter;

import com.example.contract.GoodsCart_Contract;
import com.example.model.GoodsCart_Model;
import com.example.pojo.GoodsCart;

import java.util.List;

public class GoodsCart_Presenter implements GoodsCart_Contract.Presenter ,GoodsCart_Contract.GetDataState{
    GoodsCart_Contract.Model model;
    GoodsCart_Contract.View view;

    public GoodsCart_Presenter( GoodsCart_Contract.View view) {
        this.model = new GoodsCart_Model();
        this.view = view;
    }

    @Override
    public void setUrl(String url) {
        model.setUrl(url,this);
    }

    @Override
    public void onDestorys(String e) {
        view=null;
    }

    @Override
    public void onSuccess(List<GoodsCart.DataBean> list) {
        view.onSuccess(list);
    }

    @Override
    public void onError(String s) {
        view.onError(s);
    }
}
