package com.example.admin.supplyit_customer;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ShopActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    private RecyclerView recyclerView;
    private static ShopAdapter shopAdapter;
    static ArrayList<ShopItem> shops;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        layoutManager=new LinearLayoutManager(this);
        recyclerView=(RecyclerView)findViewById(R.id.shop_recycler_list);
        recyclerView.setLayoutManager(layoutManager);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.shop_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        updateUI();
    }
    public void updateUI(){
        shops=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            ShopItem item=new ShopItem();
            item.setShop_name("Shop "+(i+1));
            item.setDesc("Grocery");
            item.setDelivery_time("Delivers in 60 min...");
            item.setImageView(R.drawable.shop_image);
            shops.add(item);
        }
        shopAdapter=new ShopAdapter(shops,getApplicationContext());
        if(swipeRefreshLayout.isRefreshing())
            swipeRefreshLayout.setRefreshing(false);
        recyclerView.setAdapter(shopAdapter);
    }
    @Override
    public void onRefresh() {
        updateUI();
    }
}
