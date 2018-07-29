package com.example.activivty;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.adapter.MyGoodsCarAdapter;
import com.example.adapter.MyMultipleItem;
import com.example.contract.GoodsCart_Contract;
import com.example.pojo.GoodsCart;
import com.example.pojo.ZDYGoodsbean;
import com.example.presenter.GoodsCart_Presenter;

import java.util.ArrayList;
import java.util.List;

public class GoodsCartActivity extends BaseActivity implements GoodsCart_Contract.View {

    private RecyclerView mGoodsRecyclerView;
    private ImageView mGoodsIvSelectAll;
    private TextView mGoodsTvSelect;
    private TextView mGoodsAllGoodsNum;
    private TextView mGoodsAllPrice;
    private Button mGoodsBtnCount;
    boolean flag = true;
    boolean f = false;
    boolean f2 = false;
    private GoodsCart_Contract.Presenter presenter;
    private List<MyMultipleItem> goodsList = new ArrayList<>();
    private MyGoodsCarAdapter adapter;
    private final String url= "http://www.zhaoapi.cn/product/getCarts?uid=71";
    private double price=0;

    @Override
    protected void setOther() {
        adapter = new MyGoodsCarAdapter(goodsList);
        mGoodsRecyclerView.setAdapter(adapter);

    }

    @Override
    protected void setListener() {
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            public int count=0;

            @Override
            public void onItemChildClick(final BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.item_iv_goodsAdd:
                        //计算总价
                        for (int i = 0; i <goodsList.size() ; i++) {
                            if (goodsList.get(position).getZdyGoodsbean().getSelected().equals("1")){
                                if (goodsList.get(position).getZdyGoodsbean().getSelected().equals("1")){
                                    price = goodsList.get(position).getZdyGoodsbean().getPrice()*goodsList.get(position).getZdyGoodsbean().getNum();
                                    count++;
                                }
                            }
                        }
                        if (price>0){
                            mGoodsAllPrice.setText("总价￥"+price);
                        }else {
                            mGoodsAllPrice.setText("总价￥"+0);
                        }
                        int num = goodsList.get(position).getZdyGoodsbean().getNum();
                        num = num + 1;
                        goodsList.get(position).getZdyGoodsbean().setNum(num);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.item_iv_jian:
                        //计算总价
                        for (int i = 0; i <goodsList.size() ; i++) {
                            if (goodsList.get(position).getZdyGoodsbean().getSelected().equals("1")){
                                if (goodsList.get(position).getZdyGoodsbean().getSelected().equals("1")){
                                    price = goodsList.get(position).getZdyGoodsbean().getPrice()*goodsList.get(position).getZdyGoodsbean().getNum();
                                    count++;
                                }
                            }
                        }
                        if (price>0){
                            mGoodsAllPrice.setText("总价￥"+price);
                        }else {
                            mGoodsAllPrice.setText("总价￥"+0);
                        }
                        int num1 = goodsList.get(position).getZdyGoodsbean().getNum();
                        if (num1 > 0) {
                            num1 = num1 - 1;
                        }
                        goodsList.get(position).getZdyGoodsbean().setNum(num1);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.item_iv_seletor:
                        boolean selectedParent = goodsList.get(position).getZdyGoodsbean().isSelectedchild();
                        selectedParent = !selectedParent;
                        goodsList.get(position).getZdyGoodsbean().setSelectedchild(selectedParent);
                        for (int i = 0; i < goodsList.size(); i++) {
                            if (selectedParent){
                                if (goodsList.get(i).getZdyGoodsbean().getSellerid().equals(goodsList.get(position).getZdyGoodsbean().getSellerid())){
                                    goodsList.get(i).getZdyGoodsbean().setSelected("1");
                                }
                            }else {
                                goodsList.get(i).getZdyGoodsbean().setSelected("0");
                            }
                        }
                        Log.i("TAG", "onItemChildClick: "+"11111111111111");
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.item_iv_seletorchild:
                        if (f){
                            goodsList.get(position).getZdyGoodsbean().setSelected("0");
                            f = false;
                        }else {
                            goodsList.get(position).getZdyGoodsbean().setSelected("1");
                            f=true;
                        }
                        //计算总价
                        for (int i = 0; i <goodsList.size() ; i++) {
                            if (goodsList.get(position).getZdyGoodsbean().getSelected().equals("1")){
                                price = price+goodsList.get(position).getZdyGoodsbean().getPrice();
                                count++;
                            }else if (goodsList.get(position).getZdyGoodsbean().getSelected().equals("0")){
                                price = price-goodsList.get(position).getZdyGoodsbean().getPrice();
                                count--;
                            }
                        }
                        if (price>0){
                            mGoodsAllPrice.setText("总价￥"+price*goodsList.get(position).getZdyGoodsbean().getNum());
                        }else {
                            mGoodsAllPrice.setText("总价￥"+0);
                        }
                        mGoodsAllGoodsNum.setText("总数："+count);
                        adapter.notifyDataSetChanged();
                }
            }
        });
        mGoodsIvSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (f2){
                    mGoodsIvSelectAll.setImageResource(R.drawable.select_false);
                    f2=false;
                }else {
                    mGoodsIvSelectAll.setImageResource(R.drawable._select_true);
                    f2=true;
                }
                for (int i = 0; i <goodsList.size() ; i++) {
                    if (f2){
                        goodsList.get(i).getZdyGoodsbean().setSelected("1");
                    }else {
                        goodsList.get(i).getZdyGoodsbean().setSelected("0");
                    }
                }
                //计算总价
                setCountPrice();
                adapter.notifyDataSetChanged();
            }
        });
    }
    //计算总价
    private void setCountPrice() {
        for (int i = 0; i <goodsList.size() ; i++) {
            if (goodsList.get(i).getZdyGoodsbean().getSelected().equals("1")){
                price = price+goodsList.get(i).getZdyGoodsbean().getPrice();
            }else if (goodsList.get(i).getZdyGoodsbean().getSelected().equals("0")){
                price = price-goodsList.get(i).getZdyGoodsbean().getPrice();
            }
        }
        if (price>0){
            mGoodsAllPrice.setText("总价￥"+price);
        }else {
            mGoodsAllPrice.setText("总价￥"+0);
        }
    }

    @Override
    protected void loadData() {
        presenter.setUrl(url);
    }

    @Override
    protected void initView() {
        mGoodsRecyclerView = (RecyclerView) findViewById(R.id.goods_recyclerView);
        mGoodsIvSelectAll = (ImageView) findViewById(R.id.goods_iv_selectAll);
        mGoodsTvSelect = (TextView) findViewById(R.id.goods_tv_select);
        mGoodsAllGoodsNum = (TextView) findViewById(R.id.goods_allGoodsNum);
        mGoodsAllPrice = (TextView) findViewById(R.id.goods_allPrice);
        mGoodsBtnCount = (Button) findViewById(R.id.goods_btn_count);
        presenter = new GoodsCart_Presenter(this);
        mGoodsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_third;
    }

    @Override
    public void onSuccess(final List<GoodsCart.DataBean> list) {
        Log.i("TAG", "onSuccess: " + list.toString());
        for (int i = 0; i < list.size(); i++) {
            ZDYGoodsbean zdyGoodsbean = new ZDYGoodsbean();
            zdyGoodsbean.setSellerName(list.get(i).getSellerName());
            List<GoodsCart.DataBean.ListBean> goodslist = list.get(i).getList();
            for (int j = 0; j < goodslist.size(); j++) {
                if (j == 0) {
                    setZdyGoodsData(zdyGoodsbean, goodslist, j);
                    goodsList.add(new MyMultipleItem(zdyGoodsbean, MyMultipleItem.TYPE_TWO));
                } else {
                    ZDYGoodsbean zdyGoodsbean1 = new ZDYGoodsbean();
                    setZdyGoodsData(zdyGoodsbean1, goodslist, j);
                    goodsList.add(new MyMultipleItem(zdyGoodsbean1, MyMultipleItem.TYPE_ONE));
                }
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setZdyGoodsData(ZDYGoodsbean zdyGoodsbean, List<GoodsCart.DataBean.ListBean> goodslist, int j) {
        zdyGoodsbean.setBargainPrice(goodslist.get(j).getBargainPrice());
        zdyGoodsbean.setCreatetime(goodslist.get(j).getCreatetime());
        zdyGoodsbean.setDetailUrl(goodslist.get(j).getDetailUrl());
        zdyGoodsbean.setImages(goodslist.get(j).getImages());
        zdyGoodsbean.setNum(goodslist.get(j).getNum());
        zdyGoodsbean.setPid(goodslist.get(j).getPid());
        zdyGoodsbean.setSelectedchild(false);
        zdyGoodsbean.setPrice(goodslist.get(j).getPrice());
        zdyGoodsbean.setSelected(goodslist.get(j).getSelected());
        zdyGoodsbean.setSellerid(goodslist.get(j).getSellerid());
        zdyGoodsbean.setSubhead(goodslist.get(j).getSubhead());
        zdyGoodsbean.setTitle(goodslist.get(j).getTitle());
    }

    @Override
    public void onError(String error) {
        Log.i("TAG", "onSuccess: " + error);
    }
}
