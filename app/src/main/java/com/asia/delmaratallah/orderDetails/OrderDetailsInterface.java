package com.asia.delmaratallah.orderDetails;

import java.util.ArrayList;

interface OrderDetailsInterface {


    void createToolbar(String title);//create Toolbar

    void getData(String orderId);//getData from database
    void createAdaptor(ArrayList<Model> orderList);//getData from database
}
