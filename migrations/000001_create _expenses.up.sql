CREATE TABLE expenses (
    id            BIGSERIAL PRIMARY KEY,
    description   TEXT NOT NULL,
    amount        NUMERIC(12, 2) NOT NULL,
    currency      CHAR(3) NOT NULL,
    category      VARCHAR(50),
    expense_date  DATE NOT NULL DEFAULT CURRENT_DATE,
    created_at    TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at    TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_expenses_expense_date ON expenses (expense_date);
CREATE INDEX idx_expenses_currency ON expenses (currency);