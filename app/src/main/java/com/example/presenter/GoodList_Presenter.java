package com.example.presenter;

import com.example.contract.GoodList_Contract;
import com.example.model.GoodList_Model;
import com.example.pojo.GoodsBean;

import java.util.List;

public class GoodList_Presenter implements GoodList_Contract.Presenter,GoodList_Contract.GetDataState {
    GoodList_Contract.View view;
    GoodList_Contract.Model model;

    public GoodList_Presenter( GoodList_Contract.View view) {
        this.view = view;
        this.model = new GoodList_Model();
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
    public void onSuccess(List<GoodsBean.DataBean> list) {
        view.onSuccess(list);
    }

    @Override
    public void onError(String s) {
        view.onError(s);
    }
}
