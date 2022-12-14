package com.project.expendituretracker.dto;

import java.time.LocalDateTime;

public class ExpenseResponseDTO {
    private Long id;
    private String itemName;
    private String amount;

    private long expenseDate;

    private String fileName;

    public ExpenseResponseDTO(Long id, String itemName, String amount, long expenseDate, String fileName) {
        this.id = id;
        this.itemName = itemName;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public long getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(long expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
