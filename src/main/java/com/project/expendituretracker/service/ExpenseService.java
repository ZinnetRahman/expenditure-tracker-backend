package com.project.expendituretracker.service;

import com.project.expendituretracker.domain.Expense;
import com.project.expendituretracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

   private  final ExpenseRepo expenseRepo;

    @Autowired
    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public Expense addExpense(Expense expense) {
        return expenseRepo.save(expense);
    }
   public List<Expense> findAllExpense(){
        return expenseRepo.findAll();
    }
    public Expense updateExpense(Expense expense){
        return expenseRepo.save(expense);

    }

    public Expense findExpenseById(Long id){
      return   expenseRepo.findExpenseById(id);
    }
    public  void  deleteExpense(Long id){
         expenseRepo.deleteExpenseById(id);
    }
}
