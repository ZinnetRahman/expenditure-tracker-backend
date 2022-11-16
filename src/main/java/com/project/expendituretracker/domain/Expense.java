package com.project.expendituretracker.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Expense implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String itemName;
    private String amount;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expenseDate;

    public Expense() {}




    public Expense(Long id, String itemName, String amount, Date expenseDate) {
        this.id = id;
        this.itemName = itemName;
        this.amount = amount;

        this.expenseDate = expenseDate;
    }
    public Long getid(){
        return id;
    }
    public  void setId(Long id){

        this.id = id;
    }

    public String getItemName(){
        return itemName;
    }
    public  void setItemName(String itemName){

        this.itemName = itemName;
    }
    public String getAmount(){
        return amount;
    }
    public  void setAmount(String amount){

        this.amount = amount;
    }
    public Date getExpenseDate(){
        return expenseDate;
    }
    public void setExpenseDate(){
        this.expenseDate = expenseDate;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", itemName=" + itemName + '\'' +
                ", amount=" + amount + + '\'' +
                ", expenseDate=" + expenseDate + '\'' +
                '}';
    }
}

