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
public class TableModel {
    String description,quantity,rate,amount;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TableModel{" + "description=" + description + ", quantity=" + quantity + ", rate=" + rate + ", amount=" + amount + '}';
    }

    public TableModel(String description, String quantity, String rate, String amount) {
        this.description = description;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
    }

    
    
    
    
    
}
