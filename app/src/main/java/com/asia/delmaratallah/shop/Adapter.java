package com.asia.delmaratallah.shop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.asia.delmaratallah.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Model> mOrderList;


     Adapter(Context mContext, ArrayList<Model> mOrderList) {
        this.mContext = mContext;
        this.mOrderList = mOrderList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_medicine_order, parent, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder,  int position) {
        // get item from arrayList
        final Model object = mOrderList.get(position);
        // set category data into views
        holder.itemOrder_name.setText(object.getName());
        holder.itemOrder_number.setText(object.getNumber());
        holder.itemOrder_price.setText(object.getPrice() + " EGP");


        if (object.getType().equals("box")){
            holder.itemOrder_box.setChecked(true);
        }else {
            holder.itemOrder_tab.setChecked(true);
        }

        Picasso.get()
                .load(object.getImage_url())
                .placeholder(R.mipmap.medicine)
                .error(R.mipmap.medicine)
                .into(holder.itemOrder_image);

        holder.itemOrder_but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemOrder_number.setText(String.valueOf(Integer.parseInt( holder.itemOrder_number.getText().toString())+1));
//                Toast.makeText(mContext,  holder.itemOrder_number.getText().toString(), Toast.LENGTH_SHORT).show();


            }
        });

        holder.itemOrder_but_sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num =Integer.parseInt(holder.itemOrder_number.getText().toString())-1;
                if (num == -1){
                    num=0;
                }

                holder.itemOrder_number.setText(String.valueOf(num));
                Toast.makeText(mContext, holder.itemOrder_number.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }


     class ViewHolder extends RecyclerView.ViewHolder {

        private TextView
                itemOrder_name,
                itemOrder_price,
                itemOrder_number;

        private RadioButton
                itemOrder_box,
                itemOrder_tab;

        private ImageView itemOrder_image;

        private Button itemOrder_but_add,itemOrder_but_sup;

         ViewHolder(View itemView) {
            super(itemView);
            itemOrder_name = itemView.findViewById(R.id.itemMyOrder_txvw_name);
            itemOrder_price = itemView.findViewById(R.id.itemMyOrder_txvw_price);
            itemOrder_number = itemView.findViewById(R.id.itemMyOrder_txvw_number);

            itemOrder_box = itemView.findViewById(R.id.itemMyOrder_rdut_box);
            itemOrder_tab = itemView.findViewById(R.id.itemMyOrder_rdut_tab);

            itemOrder_image = itemView.findViewById(R.id.itemMyOrder_img_image);

            itemOrder_but_add = itemView.findViewById(R.id.itemMyOrder_but_add);
            itemOrder_but_sup = itemView.findViewById(R.id.itemMyOrder_but_sup);


        }
    }

}