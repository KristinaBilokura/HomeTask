package com.epam.lab.Serializable;

public class DroidSoldier extends Droid {
    private int health;
    public int getHealth(){
        return health;
    }
    DroidSoldier(String nameOfD, int activityOfD,int healthOfD ) {
        super(nameOfD, activityOfD, healthOfD);
    }
}
