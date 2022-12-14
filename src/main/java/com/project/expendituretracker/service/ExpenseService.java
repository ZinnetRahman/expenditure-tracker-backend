package com.project.expendituretracker.service;

import com.project.expendituretracker.domain.Expense;
import com.project.expendituretracker.dto.ExpenseResponseDTO;
import com.project.expendituretracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepo expenseRepo;

    @Autowired
    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public Expense addExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    public List<ExpenseResponseDTO> findAllExpense() {
        List<Expense> expenseList = expenseRepo.findAll();
        List<ExpenseResponseDTO> expenseResponseDTOList = new ArrayList<>();

        for (Expense expense : expenseList) {
            ExpenseResponseDTO responseDTO = new ExpenseResponseDTO(expense.getid(),
                    expense.getItemName(), expense.getAmount(), Timestamp.valueOf(expense.getExpenseDate()).getTime(), expense.getFileName());
            expenseResponseDTOList.add(responseDTO);
        }

        return expenseResponseDTOList;
    }

    public Expense updateExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepo.deleteExpenseById(id);
    }

    public void uploadFile(MultipartFile file) throws IllegalStateException, IOException {

        Path path = Paths.get("/home/zinnetrahman/Documents/SpringBootProject/ExpenditureTrackerApplication/expendituretracker/uploads/" + file.getOriginalFilename());
        byte[] bytes = file.getBytes();
        Files.write(path, bytes);

    }


}
