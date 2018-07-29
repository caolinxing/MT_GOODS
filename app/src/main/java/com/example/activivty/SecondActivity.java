package com.example.activivty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private String pid;
    private String url;
    private WebView mSecondWeb;
    private TextView mTvAddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        if (intent != null) {
            url = intent.getStringExtra("url");
            pid = intent.getStringExtra("pid");
        }
        initView();
        mSecondWeb.loadUrl(url);
        mSecondWeb.setWebChromeClient(new WebChromeClient() {
        });
        mTvAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this,"加入购物车成功",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SecondActivity.this,GoodsCartActivity.class));
            }
        });
    }

    private void initView() {
        mSecondWeb = (WebView) findViewById(R.id.second_web);
        mTvAddCart = (TextView) findViewById(R.id.tv_addCart);
    }
}
