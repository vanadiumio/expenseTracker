package org.example.expenses.exchangerate;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "exchange_rates",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_rate",
                columnNames = {
                        "base_currency","quote_currency","rate_date"
                }

        )
)
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_currency",nullable=false,length=3)
    private String baseCurrency;

    @Column(name = "quote_currency",nullable=false,length=3)
    private String quoteCurrency;

    @Column(nullable=false,length=19,scale=6)
    private BigDecimal rate;

    @Column(name="rate_date",nullable=false)
    private LocalDate rateDate;
}
