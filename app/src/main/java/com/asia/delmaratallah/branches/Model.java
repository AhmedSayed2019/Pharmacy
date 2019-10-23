package com.asia.delmaratallah.branches;

class Model {

    private String id,name,time;

    protected Model(String id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    protected String getId() {
        return id;
    }

    protected String getName() {
        return name;
    }

    protected String getTime() {
        return time;
    }
}
