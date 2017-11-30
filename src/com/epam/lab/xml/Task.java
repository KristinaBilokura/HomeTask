package com.epam.lab.xml;


import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Task {
    private int id;
    private String task;
    private List<Seasons> datail;
    public Task() {}
    public Task(int id, String task, List<Seasons> datail) {
        super();
        this.id = id;
        this.task = task;
        this.datail = datail;
    }
    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getTask() {
        return task;
    }
    public void setTask(String questionname) {
        this.task = task;
    }
    @XmlElement
    public List<Seasons> getDatail() {
        return datail;
    }
    public void setDatail(List<Seasons> datail) {
        this.datail = datail;
    }
}