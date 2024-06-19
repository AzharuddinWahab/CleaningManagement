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
import java.io.Serializable;

public class Register implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String formatted_id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String email;
    private String contact;
    private String role;

    public Register() {
    }

    public Register(String firstName, String lastName, String username,
            String password, String address, String email, String contact, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.role = role;
    }

    public Register(int id, String firstName, String lastName, String username,
            String password, String address, String email, String contact, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.role = role;
    }

    public Register(int id,String formatted_id, String firstName, String lastName, String username,
            String password, String address, String email, String contact, String role) {
        this.id = id;
        this.formatted_id= formatted_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return the formatted_id
     */
    public String getFormatted_id() {
        return formatted_id;
    }

    /**
     * @param formatted_id the formatted_id to set
     */
    public void setFormatted_id(String formatted_id) {
        this.formatted_id = formatted_id;
    }
}
