package com.example.activivty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    private FragmentManager manager;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    
    private void init(){
        setContentView(initLayout());
        initView();
        setOther();
        loadData();
        setListener();
    }

    protected abstract void setOther();

    protected abstract void setListener();

    protected abstract void loadData();

    protected abstract void initView();

    protected abstract int initLayout();
}
