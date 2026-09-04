package rates

import (
	"time"
)

type ExchangeRate struct {
	ID             int64     `db:"id"`
	BaseCurrency   string    `db:"base_currency"`
	TargetCurrency string    `db:"target_currency"`
	Rate           float64   `db:"rate"`
	RateDate       time.Time `db:"rate_date"`
	FetchedAt      time.Time `db:"fetched_at"`
}
