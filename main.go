package main

import (
	"errors"
	"log"
	"os"

	"github.com/golang-migrate/migrate/v4"
	"github.com/golang-migrate/migrate/v4/database/postgres"
	_ "github.com/golang-migrate/migrate/v4/source/file"
	_ "github.com/jackc/pgx/v5/stdlib"
	"github.com/jmoiron/sqlx"
)

func main() {
	dsn := os.Getenv("DATABASE_URL")
	db, err := sqlx.Connect("pgx", dsn)
	if err != nil {
		panic(err)
	}
	defer closeDbConn(db)

	sqlDb := db.DB
	migrateDriver, err := postgres.WithInstance(sqlDb, &postgres.Config{})
	if err != nil {
		panic(err)
	}

	m, err := migrate.NewWithDatabaseInstance("file://migrations", "postgres", migrateDriver)
	if err != nil {
		panic(err)
	}

	if err := m.Up(); err != nil && !errors.Is(err, migrate.ErrNoChange) {
		panic(err)
	}

	log.Println("connected, migrations applied")
}

func closeDbConn(db *sqlx.DB) {
	err := db.Close()
	if err != nil {
		panic(err)
	}
}
