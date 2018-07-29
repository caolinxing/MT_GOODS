package com.example.contract;

import com.example.pojo.GoodsBean;
import com.example.pojo.GoodsCart;

import java.util.List;

public interface GoodsCart_Contract {
    interface Model {
        void setUrl(String url, GoodsCart_Contract.GetDataState getDataState);
    }
    interface GetDataState {
        void onSuccess(List<GoodsCart.DataBean> list);
        void onError(String s);
    }

    interface View {
        void onSuccess(List<GoodsCart.DataBean> list);
        void onError(String e);
    }

    interface Presenter {
        void setUrl(String url);
        void onDestorys(String e);
    }
}
