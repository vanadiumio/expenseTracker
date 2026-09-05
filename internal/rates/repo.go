package rates

import (
	"context"
	"database/sql"
)

const upsertQuery = "INSERT INTO EXPENS"

type Repo struct {
	db *sql.DB
}

func NewRepo(db *sql.DB) *Repo {
	return &Repo{db: db}
}
func (re *Repo) Upsert(ctx context.Context, r *ExchangeRate) {
	_, err := re.db.ExecContext(ctx, upsertQuery, r)
	if err != nil {
	}
}
