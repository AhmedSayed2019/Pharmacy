package com.asia.delmaratallah.orderDetails;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.asia.delmaratallah.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    private Context mContext;
    private ArrayList<Model> mOrderList;


    public Adapter(Context mContext, ArrayList<Model> mOrderList ) {
        this.mContext=mContext;
        this.mOrderList=mOrderList;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_myorder, parent, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder, final int position) {
        // get item from arrayList
        final Model object = (Model) mOrderList.get(position);
        // set category data into views
        itemMyOrder_name.setText(object.getName());
        itemMyOrder_number.setText(object.getNumber());
        itemMyOrder_type.setText(object.getType());
        itemMyOrder_price.setText(object.getPrice()+" EGP");


        Picasso.get()
                .load(object.getImage_url())
                .placeholder(R.mipmap.medicine)
                .error(R.mipmap.medicine)
                .into(itemMyOrder_image);

    }
    @Override
    public int getItemCount() {
        return mOrderList.size();
    }

        private TextView
                itemMyOrder_name,
                itemMyOrder_number
                ,itemMyOrder_type
                ,itemMyOrder_price;

        private ImageView itemMyOrder_image;

    public class ViewHolder extends RecyclerView.ViewHolder{



        public ViewHolder(View itemView) {
            super(itemView);
            itemMyOrder_name=itemView.findViewById(R.id.itemMyOrder_name);
            itemMyOrder_number=itemView.findViewById(R.id.itemMyOrder_number);
            itemMyOrder_type=itemView.findViewById(R.id.itemMyOrder_type);
            itemMyOrder_price=itemView.findViewById(R.id.itemMyOrder_price);

            itemMyOrder_image=itemView.findViewById(R.id.itemMyOrder_image);


        }
    }
}