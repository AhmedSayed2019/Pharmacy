package com.asia.delmaratallah.orders;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asia.delmaratallah.R;
import com.asia.delmaratallah.orderDetails.OrderDetails;

import java.util.ArrayList;

class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Model> mOrdersList;


    public Adapter(Context mContext, ArrayList<Model> mOrderList) {
        this.mContext = mContext;
        this.mOrdersList = mOrderList;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_order, parent, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder,  int position) {
        // get item from arrayList
        final Model object = (Model) mOrdersList.get(position);
        // set category data into views
        holder.itemOrders_txvw_date.setText(object.getDate());
        holder.itemOrders_txvw_state.setText(object.getState());
        holder.itemOrders_txvw_price.setText(object.getPrice() + " EGP");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bus =new Intent(mContext,OrderDetails.class);
                Bundle bundle=new Bundle();
                bundle.putString("orderID",object.getId());
                bus.putExtras(bundle);
                mContext.startActivity(bus);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mOrdersList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView
                itemOrders_txvw_date,
                itemOrders_txvw_price,
                itemOrders_txvw_state;



        public ViewHolder(View itemView) {
            super(itemView);
            itemOrders_txvw_date = itemView.findViewById(R.id.itemOrders_txvw_date);
            itemOrders_txvw_price = itemView.findViewById(R.id.itemOrders_txvw_price);
            itemOrders_txvw_state = itemView.findViewById(R.id.itemOrders_txvw_state);



        }
    }

}