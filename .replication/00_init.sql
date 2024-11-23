CREATE USER replica_user
    WITH REPLICATION ENCRYPTED PASSWORD 'replica_password';

SELECT pg_create_physical_replication_slot('replication_slot');