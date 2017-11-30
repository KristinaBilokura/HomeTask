package com.epam.lab.Serializable;

import java.io.Serializable;
public  class Droid implements Serializable {
    private String nameOfDroid;
    transient private int  health;
    private int  activity;
    Droid(String nameOfD, int activityOfD, int healthOfD)
    {
        nameOfDroid = nameOfD;
        activity = activityOfD;
        health= healthOfD;
    }



    public String getname(){
        return nameOfDroid;
    }
    public int getActivity(){
        return activity;
    }
    public int getHealth(){
        return health;
    }

    public int setActivity(int activity) {
        this.activity = activity;
        return activity;
    }


}
