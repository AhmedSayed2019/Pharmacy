package com.asia.delmaratallah.branches;

import android.content.Context;
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


    public Adapter(Context mContext, ArrayList<Model> mOrderList) {
        this.mContext = mContext;
        this.mOrderList = mOrderList;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_branches, parent, false);
        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder,  int position) {
        // get item from arrayList
        final Model object = (Model) mOrderList.get(position);
        // set category data into views
        holder.itemBranches_name.setText(object.getName());
        holder.itemBranches_time.setText(object.getTime()+" Houre");


    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView
                itemBranches_name,
                itemBranches_time;


        public ViewHolder(View itemView) {
            super(itemView);
            itemBranches_name = itemView.findViewById(R.id.itemBranches_name);
            itemBranches_time = itemView.findViewById(R.id.itemBranches_time);



        }
    }

}