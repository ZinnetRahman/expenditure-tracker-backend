package com.project.expendituretracker.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Expense implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String itemName;
    private String amount;

    @Column(name = "expense_date")
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a", shape = JsonFormat.Shape.STRING)
    private LocalDateTime expenseDate;

    private String fileName;

    public Expense() {}

    public Expense(Long id, String itemName, String amount, LocalDateTime expenseDate, String fileName) {
        this.id = id;
        this.itemName = itemName;
        this.amount = amount;

        this.expenseDate = expenseDate;
        this.fileName = fileName;
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
    public LocalDateTime getExpenseDate(){
        return expenseDate;
    }
    public void setExpenseDate(String dataStr){

        this.expenseDate = dataStr == null ? null : LocalDateTime.parse(dataStr);
    }
    public String getFileName() {
        return "http://localhost:8080/resources/"+fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName.substring(12);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", itemName=" + itemName + '\'' +
                ", amount=" + amount + + '\'' +
                ", expenseDate=" + expenseDate + '\'' +
                ", fileName=" + fileName + '\'' +
                '}';
    }


}

