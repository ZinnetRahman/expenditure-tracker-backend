package com.project.expendituretracker.controller;

import com.project.expendituretracker.domain.Expense;
import com.project.expendituretracker.service.ExpenseService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getAllExpenses () {
        List<Expense> expenses = expenseService.findAllExpense();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Expense> getExpenseById (@PathVariable("id") Long id) {
        Expense expense = expenseService.findExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
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



}
