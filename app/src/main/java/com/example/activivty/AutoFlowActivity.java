package com.example.activivty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *  流式布局：AutoFlowLayout
 * @author  user
 * @version 1.0
 * @date 2018/7/29 19:14
 */
public class AutoFlowActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mOneIvSearch;
    private EditText mOneEtSearch;
    private TextView mOneTvCancle;
    private ImageView mOneIvDelete;
    private AutoFlowLayout mOneAutoFlowLayout;
    private AutoFlowLayout mOneAutoFlowLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_flow);
        //初始化布局
        initView();
        //设置监听
        setListener();
        ArrayList<String> list01 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i%2==0){
                list01.add("消除bug");
            }else {
                list01.add("这是测试数据");
            }
        }
        setAutoFlowLayout_one(list01,true);
        mOneAutoFlowLayout.setOnItemClickListener(new AutoFlowLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int i, View view) {
                Intent intent = new Intent(AutoFlowActivity.this, MainActivity.class);
                TextView tv = view.findViewById(R.id.auto_tv);
                intent.putExtra("name",tv.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void setListener() {
        mOneIvDelete.setOnClickListener(this);
        mOneIvSearch.setOnClickListener(this);
        mOneTvCancle.setOnClickListener(this);
    }

    private void initView() {
        mOneIvSearch = (ImageView) findViewById(R.id.one_iv_search);
        mOneEtSearch = (EditText) findViewById(R.id.one_et_search);
        mOneTvCancle = (TextView) findViewById(R.id.one_tv_cancle);
        mOneIvDelete = (ImageView) findViewById(R.id.one_iv_delete);
        mOneAutoFlowLayout = (AutoFlowLayout) findViewById(R.id.one_autoFlowLayout);
        mOneAutoFlowLayout2 = (AutoFlowLayout) findViewById(R.id.one_autoFlowLayout2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.one_iv_delete:
                mOneAutoFlowLayout.removeAllViews();
                break;
            case R.id.one_iv_search:
                List<String> list = new ArrayList<>();
                list.add(mOneEtSearch.getText().toString());
                Intent intent = new Intent(AutoFlowActivity.this, MainActivity.class);
                intent.putExtra("name",mOneEtSearch.getText().toString());
                startActivity(intent);
                mOneEtSearch.getText().clear();
                boolean falg = false;
                setAutoFlowLayout_one(list,falg);
                break;
            case R.id.one_tv_cancle:
                mOneEtSearch.getText().clear();
                break;
        }
    }

    private void setAutoFlowLayout_one(final List<String> list, boolean f) {
        if (f){
            mOneAutoFlowLayout2.setAdapter(new FlowAdapter(list) {
                @Override
                public View getView(int i) {
                    View v = View.inflate(AutoFlowActivity.this,R.layout.auto_layout,null);
                    for (int j = 0; j <list.size() ; j++) {
                        TextView tv = v.findViewById(R.id.auto_tv);
                        tv.setText(list.get(i));
                    }
                    return v;
                }
            });
        }else {
            mOneAutoFlowLayout.setAdapter(new FlowAdapter(list) {
                @Override
                public View getView(int i) {
                    View v = View.inflate(AutoFlowActivity.this,R.layout.auto_layout,null);
                    for (int j = 0; j <list.size() ; j++) {
                        TextView tv = v.findViewById(R.id.auto_tv);
                        tv.setText(list.get(i));
                        list.clear();
                    }
                    return v;
                }
            });
        }
    }
}
