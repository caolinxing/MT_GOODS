package com.example.model;

import com.example.contract.GoodsCart_Contract;
import com.example.pojo.GoodsBean;
import com.example.pojo.GoodsCart;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GoodsCart_Model implements GoodsCart_Contract.Model {
    @Override
    public void setUrl(String url, final GoodsCart_Contract.GetDataState getDataState) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getDataState.onError(e.getMessage().toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                GoodsCart goodsBean = gson.fromJson(response.body().string(), GoodsCart.class);
                getDataState.onSuccess(goodsBean.getData());
            }
        });
    }
}
