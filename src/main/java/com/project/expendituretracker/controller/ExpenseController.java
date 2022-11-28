package com.project.expendituretracker.controller;

import com.project.expendituretracker.domain.Expense;
import com.project.expendituretracker.repository.ExpenseRepo;
import com.project.expendituretracker.service.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    @Autowired
    ExpenseRepo expenseRepo;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getAllExpenses () {
        List<Expense> expenses = expenseService.findAllExpense();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }




    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        Expense newExpense = expenseService.addExpense(expense);
        return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense) {
        Expense updateExpense = expenseService.updateExpense(expense);
        return new ResponseEntity<>(updateExpense, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/file")
    public void uploadFile(@RequestParam("file")MultipartFile file) throws IllegalStateException, IOException {

        expenseService.uploadFile(file);
    }

    @GetMapping("/find/{itemName}")
    public ResponseEntity<List<Expense>> getExpensesByItemName(@PathVariable("itemName") String itemName) {
        return new ResponseEntity<List<Expense>>(expenseRepo.findByItemNameContainingIgnoreCase(itemName), HttpStatus.OK);
    }





}
