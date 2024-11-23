#!/bin/bash

BASE_DIR="$(dirname "$(realpath "$0")")"
export $(grep -v '^#' "$BASE_DIR/../../docker/.env" | xargs)

BACKUP_DIR="./backups"
CONTAINER_NAME="user_db"
DB_NAME=$USER_SERVICE_POSTGRES_DB
DB_USER=$USER_SERVICE_POSTGRES_USER

MAX_BACKUPS=10
TIME_BETWEEN_BACKUPS_IN_SECONDS=30

mkdir -p $BACKUP_DIR

while true
do
  TIMESTAMP=$(date +"%Y_%m_%d-%H:%M:%S")

  docker exec $CONTAINER_NAME pg_dump -U $DB_USER -d $DB_NAME > $BACKUP_DIR/db_backup_$TIMESTAMP.sql

  echo "Backup created at $BACKUP_DIR/user_db_backup_$TIMESTAMP.sql"

  BACKUP_COUNT=$(ls -1 $BACKUP_DIR/*.sql | wc -l)

  if [ $BACKUP_COUNT -gt $MAX_BACKUPS ]; then
    OLDEST_BACKUP=$(ls -1t $BACKUP_DIR/*.sql | tail -n +$(($MAX_BACKUPS + 1)))
    echo "Deleting old backups: $OLDEST_BACKUP"
    rm $OLDEST_BACKUP
  fi

  sleep 30
done