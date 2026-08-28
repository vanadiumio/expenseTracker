CREATE TABLE expenses (
                          id              BIGSERIAL PRIMARY KEY,
                          amount          NUMERIC(19,4) NOT NULL,
                          currency        VARCHAR(3) NOT NULL,
                          category        VARCHAR(50) NOT NULL,
                          description     VARCHAR(255),
                          spent_on        DATE NOT NULL,
                          created_at      TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_expenses_spent_on ON expenses (spent_on);