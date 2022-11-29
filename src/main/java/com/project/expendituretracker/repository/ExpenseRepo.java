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
            
            SELECT id, amount, expense_date, file_name, item_name
            	FROM expense order by id DESC;
            """ ;

    @Query(value = EXPENSE_LIST, nativeQuery = true)
    List<Expense> findAll();


    List<Expense> findByItemNameContainingIgnoreCase(String itemName);


}
