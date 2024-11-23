CREATE TABLE IF NOT EXISTS t_user
(
    id    BIGSERIAL PRIMARY KEY NOT NULL,
    email VARCHAR(256)          NOT NULL,

    CONSTRAINT idx_t_user__email_unq UNIQUE (email)
);