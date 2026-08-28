package org.example.expenses.expense;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseRequest {
    BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    String currency;


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    String category;

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
