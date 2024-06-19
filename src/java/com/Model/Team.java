/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Model;

/**
 *
 * @author THINKPAD
 */
public class Team {
    protected int user_id;
    protected String firstname;
    protected String lastname;
    protected String ic_no;
    protected String address;
    protected String contact;
    protected String email;
    protected String reg_date;
    protected int jobid;
    
    public Team(){
        
    }
    
    public Team(String firstname, String lastname, String ic_no, String address,
            String contact, String email, String reg_date, int jobid) {
        super();
        this.firstname= firstname;
        this.lastname = lastname;
        this.ic_no = ic_no;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.reg_date = reg_date;
        this.jobid = jobid;
    }
    
    public Team(int user_id, String firstname, String lastname, String ic_no,
            String address, String contact, String email, String reg_date, int jobid) {
        super();
        this.user_id = user_id;
        this.firstname= firstname;
        this.lastname = lastname;
        this.ic_no = ic_no;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.reg_date = reg_date;
        this.jobid = jobid;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIc_no() {
        return ic_no;
    }

    public void setIc_no(String ic_no) {
        this.ic_no = ic_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    
    
}
