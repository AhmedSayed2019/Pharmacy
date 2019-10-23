package com.asia.delmaratallah.shop;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.asia.delmaratallah.OrderInfo;
import com.asia.delmaratallah.R;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class Shop extends AppCompatActivity implements ShopInterface {

    private RecyclerView myList;
    private ArrayList<Model> orderList;
    private FloatingActionButton shop_flbut_order;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        mContext=Shop.this;

        myList=findViewById(R.id.shop_rcvw_list);
        shop_flbut_order=findViewById(R.id.shop_flbut_order);





        getData("orderId");


        shop_flbut_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float totle=0 ;
                for (int index=0;index < orderList.size();index++){
                    try {
                        totle+=Float.parseFloat( orderList.get(index).getPrice() );//calculate total price
                    }catch (Exception e){

                    }

                }
                openDialog(totle);
            }
        });
    }

    @Override
    public void createToolbar(String title) {

    }

    @Override
    public void getData(String orderId) {
        orderList=new ArrayList<Model>();
        orderList.add(new Model("1","panadol","https://images.indianexpress.com/2017/04/meds-759.jpg","1","12","tab"));
        orderList.add(new Model("2","panadol","https://images.indianexpress.com/2017/04/meds-759.jpg","1","32","box"));
        orderList.add(new Model("3","panadol","https://images.indianexpress.com/2017/04/meds-759.jpg","2","21","box"));
        orderList.add(new Model("4","panadol","https://images.indianexpress.com/2017/04/meds-759.jpg","1","32","box"));
        orderList.add(new Model("5","panadol","https://images.indianexpress.com/2017/04/meds-759.jpg","1","3.2","box"));

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


    @Override
    public void openDialog(float totle_price) {
        final Dialog dialog = new Dialog(mContext, R.style.Theme_Dialog);
        dialog.setContentView(R.layout.dialoge_check_order);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationLeft;
        //find Views
        TextView txvw_totle = dialog.findViewById(R.id.dialogCheckOrder_txvw_totle);

        Button but_order = dialog.findViewById(R.id.dialogCheckOrder_but_order);

        Button but_edit = dialog.findViewById(R.id.dialogCheckOrder_but_edit);

        txvw_totle.setText(String.valueOf(totle_price));

        but_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        but_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,OrderInfo.class));
            }
        });




        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }
}
