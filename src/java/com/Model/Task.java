/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Model;

/**
 *
 * @author ASUSVIVO
 */
public class Task {
    private int id;
    private String customerName;
    private String customerHpNo;
    private int staffid;
    private String formattedStaffId;
    private String buildingType;
    private String date;
    private String addNote;

    public Task(){}
    
    public Task(String customerName, String customerHpNo,
            int staffid, String buildingType,String date, String addNote){
        this.customerName = customerName;
        this.customerHpNo = customerHpNo;
        this.staffid = staffid;
        this.buildingType = buildingType;
        this.date = date;
        this.addNote = addNote;
    }
    
    public Task(int id, String customerName, String customerHpNo,
            int staffid, String buildingType,String date, String addNote){
        this.id = id;
        this.customerName = customerName;
        this.customerHpNo = customerHpNo;
        this.staffid = staffid;
        this.buildingType = buildingType;
        this.date = date;
        this.addNote = addNote;
    }
        public Task(int id, String customerName, String customerHpNo,
            int staffid,String formattedStaffId, String buildingType,String date, String addNote){
        this.id = id;
        this.customerName = customerName;
        this.customerHpNo = customerHpNo;
        this.staffid = staffid;
        this.formattedStaffId=formattedStaffId;
        this.buildingType = buildingType;
        this.date = date;
        this.addNote = addNote;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerHpNo() {
        return customerHpNo;
    }

    public void setCustomerHpNo(String customerHpNo) {
        this.customerHpNo = customerHpNo;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String taskType) {
        this.buildingType = taskType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddNote() {
        return addNote;
    }

    public void setAddNote(String addNote) {
        this.addNote = addNote;
    }

    /**
     * @return the formattedStaffId
     */
    public String getFormattedStaffId() {
        return formattedStaffId;
    }

    /**
     * @param formattedStaffId the formattedStaffId to set
     */
    public void setFormattedStaffId(String formattedStaffId) {
        this.formattedStaffId = formattedStaffId;
    }
    
    
}
