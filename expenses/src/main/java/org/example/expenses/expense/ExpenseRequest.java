package org.example.expenses.expense;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseRequest {
   @NotNull @Positive
   BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @NotBlank @Size(min = 3, max = 3) String currency;


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @NotBlank @Size(min=1,max=100) String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   @NotNull @PastOrPresent
   LocalDate spentOn;
    public LocalDate getSpentOn() {
        return spentOn;
    }

    public void setSpentOn(LocalDate spentOn) {
        this.spentOn = spentOn;
    }

    public String toString() {
        return "ExpenseRequest [amount=" + amount + ", currency=" + currency + ", category=" + category + ", description=" + description + ", spentOn=" + spentOn + "]";
    }
}
