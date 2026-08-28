CREATE TABLE exchangerates (
    id BIGSERIAL PRIMARY KEY,
    base_currency VARCHAR(3) NOT NULL,
    quote_currency VARCHAR(3) NOT NULL,
    rate NUMERIC(19, 6) NOT NULL,
    rate_date DATE NOT NULL,
    CONSTRAINT unique_rate UNIQUE (base_currency, quote_currency, rate_date)
);
