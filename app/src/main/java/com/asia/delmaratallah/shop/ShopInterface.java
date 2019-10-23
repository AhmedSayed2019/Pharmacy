package com.asia.delmaratallah.shop;

import java.util.ArrayList;

interface ShopInterface {



    void createToolbar(String title);//create Toolbar

    void getData(String orderId);//getData from database

    void createAdaptor(ArrayList<Model> orderList);//getData from database

    void openDialog(float totle_price);//open Dialog to accept

}
