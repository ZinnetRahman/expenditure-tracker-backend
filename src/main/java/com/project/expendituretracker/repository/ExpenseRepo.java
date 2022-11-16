package com.project.expendituretracker.repository;

import com.project.expendituretracker.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    void deleteExpenseById(Long id);

    Expense findExpenseById(Long id);
}
