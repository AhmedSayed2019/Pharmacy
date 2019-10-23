package com.asia.delmaratallah.shop;

class Model {

    private String id,name, image_url,number,price,type;


    public Model(String id, String name, String image_url, String number, String price, String type) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.number = number;
        this.price = price;
        this.type = type;
    }


    protected String getId() {
        return id;
    }

    protected String getName() {
        return name;
    }

    protected String getImage_url() {
        return image_url;
    }

    protected String getNumber() {
        return number;
    }

    protected void setNumber(String number) {
        this.number = number;
    }

    protected String getPrice() {
        return price;
    }

    protected String getType() {
        return type;
    }


}
