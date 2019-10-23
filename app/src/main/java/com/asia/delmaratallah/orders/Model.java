package com.asia.delmaratallah.orders;

class Model {

    private String id ,state,price,date;

    protected Model(String id, String state, String price, String date) {
        this.id = id;
        this.state = state;
        this.price = price;
        this.date = date;
    }

    protected String getId() {
        return id;
    }

    protected String getState() {
        return state;
    }

    protected String getPrice() {
        return price;
    }

    protected String getDate() {
        return date;
    }
}
