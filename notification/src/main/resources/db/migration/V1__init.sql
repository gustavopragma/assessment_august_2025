CREATE TABLE notification (
   id VARCHAR(255) PRIMARY KEY NOT NULL,
   type VARCHAR(255),
   message VARCHAR(255),
   tournament_id VARCHAR(255)
);