package com.asia.delmaratallah.orders;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.asia.delmaratallah.R;

import java.util.ArrayList;

public class Orders extends AppCompatActivity implements OrdersInterface{


    private RecyclerView myList;
    private ArrayList<Model> mOrdersList;

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        mContext=Orders.this;

        myList=findViewById(R.id.orders_rcvw_list);

        getData();

    }

    @Override
    public void createToolbar(String title) {

    }

    @Override
    public void getData() {

        mOrdersList =new ArrayList<Model>();

        mOrdersList.add(new Model("1","Delivered","124","31/10/2018  4:03 PM"));
        mOrdersList.add(new Model("2","Delivered","122","31/10/2018  9:03 AM"));
        mOrdersList.add(new Model("3","Delivered","11","31/10/2018  6:03 AM"));
        mOrdersList.add(new Model("4","Delivered","12","31/10/2018  3:03 PM"));
        mOrdersList.add(new Model("5","Delivered","101","31/10/2018  1:03 PM"));

        createAdaptor(mOrdersList);
    }

    @Override
    public void createAdaptor(ArrayList<Model> ordersList) {
        // create adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        myList.setLayoutManager(layoutManager);
        Adapter adapter = new Adapter(mContext,ordersList);
        myList.setAdapter(adapter);
    }
}
