package com.example.contract;

import com.example.pojo.GoodsBean;

import java.util.List;

public interface GoodList_Contract {
    interface Model {
        void setUrl(String url, GetDataState getDataState);
    }
    interface GetDataState {
        void onSuccess(List<GoodsBean.DataBean> list);
        void onError(String s);
    }

    interface View {
        void onSuccess(List<GoodsBean.DataBean> list);
        void onError(String e);
    }

    interface Presenter {
        void setUrl(String url);
        void onDestorys(String e);
    }
}
