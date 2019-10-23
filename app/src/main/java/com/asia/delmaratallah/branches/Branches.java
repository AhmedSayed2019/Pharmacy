package com.asia.delmaratallah.branches;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.asia.delmaratallah.R;

import java.util.ArrayList;

public class Branches extends AppCompatActivity implements BranchesInterface{

    private RecyclerView myList;
    private ArrayList<Model> branchesList;

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branches);
        mContext=Branches.this;

        myList=findViewById(R.id.branches_rcvw_list);

        getData();
    }

    @Override
    public void createToolbar(String title) {

    }

    @Override
    public void getData() {
        branchesList=new ArrayList<Model>();
        branchesList.add(new Model("1","Green Plaza","24"));
        branchesList.add(new Model("2","Green Plaza","8 AM - 12 PM"));
        branchesList.add(new Model("3","Green Plaza","24"));
        branchesList.add(new Model("4","Green Plaza","8 AM - 12 PM"));
        branchesList.add(new Model("5","Green Plaza","24"));

        createAdaptor(branchesList);
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
