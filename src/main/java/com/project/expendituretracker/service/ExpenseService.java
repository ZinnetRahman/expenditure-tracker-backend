package com.project.expendituretracker.service;

import com.project.expendituretracker.domain.Expense;
import com.project.expendituretracker.repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ExpenseService {

   private  final ExpenseRepo expenseRepo;
    private Path root;


    @PostConstruct
    public void init() {
        this.root = Paths.get("uploads");
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }




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








    public  void  deleteExpense(Long id){
         expenseRepo.deleteExpenseById(id);
    }




    public void uploadFile(MultipartFile file) throws IllegalStateException, IOException {

//           Files.createDirectory(root);


//            file.transferTo(new File("ExpenseFile/" + file.getOriginalFilename()));

//        Files.move((Path) file.getInputStream(), this.root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);


        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file " + filename);
            }

            // This is a security check
            if (filename.contains("..")) {
                throw new RuntimeException("Cannot store file with relative path outside current directory " + filename);
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.root.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + filename, e);
        }


    }


}
