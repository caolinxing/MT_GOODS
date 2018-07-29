package com.example.activivty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.adapter.MyMutilAdapter;
import com.example.contract.GoodList_Contract;
import com.example.pojo.GoodsBean;
import com.example.presenter.GoodList_Presenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GoodList_Contract.View, View.OnClickListener {
    private String url = "http://www.zhaoapi.cn/product/searchProducts?keywords=";
    private String url_page = "&page=";
    private String url_sort = "&sort=";
    private int page = 0;
    private int sort = 0;
    private List<GoodsBean.DataBean> datasList = new ArrayList<>();
    private MyMutilAdapter myMutilAdapter;
    private ImageView mTwoIvSearch;
    private EditText mTwoEtSearch;
    private ImageView mTwoIvQie;
    private RecyclerView mTwoRecycler;
    private boolean flag = true;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        final GoodList_Contract.Presenter presenter = new GoodList_Presenter(this);
        myMutilAdapter = new MyMutilAdapter(R.layout.item_shopr,datasList);
        mTwoRecycler.setAdapter(myMutilAdapter);
        if (getIntent()!=null){
            Intent intent = getIntent();
            name = intent.getStringExtra("name");
        }
        presenter.setUrl(url+name+url_page+page+url_sort+sort);

        mTwoIvQie.setOnClickListener(this);
        myMutilAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener(){

            @Override
            public void onLoadMoreRequested() {
                mTwoRecycler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.setUrl("http://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA&page=1&sort=0");
                        myMutilAdapter.loadMoreComplete();
                    }
                },300);

            }
        });
        myMutilAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("url",datasList.get(position).getDetailUrl());
                intent.putExtra("id",datasList.get(position).getPid());
                startActivity(intent);
            }
        });


    }

    @Override
    public void onSuccess(final List<GoodsBean.DataBean> list) {
        Log.i("TAG", "onSuccess: "+list.size());
        datasList.addAll(list);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                myMutilAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onError(String e) {
        Log.i("tag", "onError: "+e);
    }

    private void initView() {
        mTwoIvSearch = (ImageView) findViewById(R.id.two_iv_search);
        mTwoEtSearch = (EditText) findViewById(R.id.two_et_search);
        mTwoIvQie = (ImageView) findViewById(R.id.two_iv_qie);
        mTwoRecycler = (RecyclerView) findViewById(R.id.two_recycler);
        mTwoRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {

        if (flag){
            mTwoRecycler.setLayoutManager(new GridLayoutManager(this,2));
            flag = false;
        }else {
            mTwoRecycler.setLayoutManager(new LinearLayoutManager(this));
            flag = true;
        }

    }
}
