package org.example.expenses.expense;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository ExpenseRepository) {
        this.expenseRepository = ExpenseRepository;
    }

    @PostMapping
    public Expense createExpense(@RequestBody ExpenseRequest expenseRequest) {
        Expense expense =new Expense();
        expense.setAmount(expenseRequest.getAmount());
        expense.setCurrency(expenseRequest.getCurrency());
        expense.setCategory(expenseRequest.getCategory());
        expense.setDescription(expenseRequest.getDescription());
        expense.setSpentOn(expenseRequest.getSpentOn());
        return expenseRepository.save(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
