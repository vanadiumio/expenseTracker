CREATE TABLE exchange_rates (
    id              BIGSERIAL PRIMARY KEY,
    base_currency   CHAR(3) NOT NULL,
    target_currency CHAR(3) NOT NULL,
    rate            NUMERIC(18, 6) NOT NULL,
    rate_date       DATE NOT NULL,
    fetched_at      TIMESTAMPTZ NOT NULL DEFAULT now(),
    UNIQUE (base_currency, target_currency, rate_date)
);

CREATE INDEX idx_exchange_rates_pair_date ON exchange_rates (base_currency, target_currency, rate_date);