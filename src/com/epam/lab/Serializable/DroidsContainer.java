package com.epam.lab.Serializable;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DroidsContainer <Name extends Droid> implements Serializable {
    private static final Logger log = Logger.getLogger(LinkedList.class);
    private List<Name> container = new ArrayList<>();
    private Name[] names;
    public DroidsContainer() {
    }
    void print()
    {
        for(Droid name : container)
        {
            log.info(name.getname());
            log.info(name.getActivity());
            log.info(name.getHealth());
        }
    }

    public void put(Name droid2)
    {
        container.add(droid2);
    }
}
