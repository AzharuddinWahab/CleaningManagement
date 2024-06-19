/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Model;

/**
 *
 * @author azhar
 */
public class Reports {

    protected int id;
    protected String tool;
    protected int quantity;
    protected int taskid;
    protected String description;

    public Reports() {
    }

    public Reports(String tool, int quantity, int taskid, String description) {
        this.tool = tool;
        this.quantity = quantity;
        this.taskid = taskid;
        this.description=description;
    }

    public Reports(int id, String tool, int quantity, int taskid, String description) {
        this.id = id;
        this.tool = tool;
        this.quantity = quantity;
        this.taskid = taskid;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
