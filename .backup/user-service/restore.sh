#!/bin/bash

BASE_DIR="$(dirname "$(realpath "$0")")"

export $(grep -v '^#' "$BASE_DIR/../../docker/.env" | xargs)

BACKUP_DIR="./backups"
CONTAINER_NAME="user_db"
DB_NAME=${USER_SERVICE_POSTGRES_DB:-user_db}
DB_USER=${USER_SERVICE_POSTGRES_USER:-bodyashah}

echo "Available backups:"
ls -1 $BACKUP_DIR

echo "Backup to restore:"
read BACKUP_FILE

if [ ! -f "$BACKUP_DIR/$BACKUP_FILE" ]; then
  echo "Backup file not found: $BACKUP_DIR/$BACKUP_FILE"
  exit 1
fi

echo "Dropping existing database (if exists)..."
docker exec -i $CONTAINER_NAME psql -U $DB_USER -d postgres -c "DROP DATABASE IF EXISTS $DB_NAME;"

echo "Creating new database..."
docker exec -i $CONTAINER_NAME psql -U $DB_USER -d postgres -c "CREATE DATABASE $DB_NAME;"

echo "Restoring database from backup..."
docker exec -i $CONTAINER_NAME psql -U $DB_USER -d $DB_NAME < "$BACKUP_DIR/$BACKUP_FILE"

if [ $? -eq 0 ]; then
  echo "Database restored successfully from $BACKUP_DIR/$BACKUP_FILE"
else
  echo "Error occurred during the restore process"
  exit 1
fi
