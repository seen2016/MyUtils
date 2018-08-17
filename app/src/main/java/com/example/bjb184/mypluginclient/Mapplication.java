package com.example.bjb184.mypluginclient;

import android.app.Application;

/*
 *
 *作者：BJB184
 *日期：18/08/13
 */public class Mapplication extends Application {

     private String text;

     private static Mapplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        text="你好应用";
        instance=this;
    }
    public static Mapplication getInstance(){
        if (instance==null)
        {
            instance=new Mapplication();
        }
        return instance;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
