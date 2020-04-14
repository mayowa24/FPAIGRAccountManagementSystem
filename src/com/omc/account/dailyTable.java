/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omc.account;

/**
 *
 * @author HP-PC
 */
public class dailyTable {
    String date,description,quantity,amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "dailyTable{" + "date=" + date + ", description=" + description + ", quantity=" + quantity + ", amount=" + amount + '}';
    }

    public dailyTable(String date, String description, String quantity, String amount) {
        this.date = date;
        this.description = description;
        this.quantity = quantity;
        this.amount = amount;
    }
    
    
}
