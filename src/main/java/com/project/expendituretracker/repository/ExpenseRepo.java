package com.project.expendituretracker.repository;

import com.project.expendituretracker.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long>, JpaSpecificationExecutor<Expense> {

    void deleteExpenseById(Long id);

    String EXPENSE_LIST = """
            
            SELECT
            *
            FROM expense
            ORDER BY id DESC;
            """ ;
    @Query(value = EXPENSE_LIST, nativeQuery = true)
    List<Expense> findAll();

    List<Expense> findByItemNameContainingIgnoreCase(String itemName);



}
