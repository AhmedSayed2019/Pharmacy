package com.asia.delmaratallah.orderDetails;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.asia.delmaratallah.R;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity implements OrderDetailsInterface {
    private RecyclerView myList;
    private ArrayList<Model> orderList;

    private String orderId;

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        mContext=OrderDetails.this;

        myList=findViewById(R.id.orderDetails_rcvw_list);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle bundle=getIntent().getExtras();

        try {
            orderId=  bundle.getString("orderID");
            getData(orderId);
        }catch (Exception e){

        }
    }

    @Override
    public void createToolbar(String title) {

    }

    @Override
    public void getData(String orderId) {
        orderList=new ArrayList<Model>();
        orderList.add(new Model("1","panadol","https://images.indianexpress.com/2017/04/meds-759.jpg","1","34","box"));
        orderList.add(new Model("2","panadol","https://images.indianexpress.com/2017/04/meds-759.jpg","1","50","box"));
        orderList.add(new Model("3","panadol","https://images.indianexpress.com/2017/04/meds-759.jpg","2","110","box"));
        orderList.add(new Model("4","panadol","https://images.indianexpress.com/2017/04/meds-759.jpg","1","10","box"));

        createAdaptor(orderList);

    }

    @Override
    public void createAdaptor(ArrayList<Model> orderList) {
        // create adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        myList.setLayoutManager(layoutManager);
        Adapter adapter = new Adapter(mContext,orderList);
        myList.setAdapter(adapter);
    }
}
