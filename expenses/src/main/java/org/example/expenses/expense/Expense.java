package org.example.expenses.expense;

import jakarta.persistence.*;
        import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(length = 255)
    private String description;

    @Column(name = "spent_on", nullable = false)
    private LocalDate spentOn;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    protected Expense() {} // JPA needs a no-arg constructor

    public Expense(BigDecimal amount, String currency, String category,
                   String description, LocalDate spentOn) {
        this.amount = amount;
        this.currency = currency;
        this.category = category;
        this.description = description;
        this.spentOn = spentOn;
    }

    // getters — no setters for now, keep it immutable-ish until you need otherwise
    public Long getId() { return id; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public LocalDate getSpentOn() { return spentOn; }
    public OffsetDateTime getCreatedAt() { return createdAt; }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSpentOn(LocalDate spentOn) {
        this.spentOn = spentOn;
    }
}