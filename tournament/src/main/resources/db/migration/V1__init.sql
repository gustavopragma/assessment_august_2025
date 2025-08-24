CREATE TABLE videogame (
   id VARCHAR(255) PRIMARY KEY NOT NULL,
   name VARCHAR(255),
   genre VARCHAR(255),
   number_players INTEGER
);

CREATE TABLE streaming (
   id VARCHAR(255) PRIMARY KEY NOT NULL,
   name VARCHAR(255),
   platform VARCHAR(255),
   url VARCHAR(255)
);

CREATE TABLE category (
  id VARCHAR(255) PRIMARY KEY NOT NULL,
  name VARCHAR(255),
  max_participants INTEGER,
  max_spectators INTEGER,
  free BOOLEAN
);

CREATE TABLE tournament (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    owner VARCHAR(255),
    streaming_id VARCHAR(255),
    category_id VARCHAR(255),
    videogame_id VARCHAR(255),
    CONSTRAINT FK_streaming FOREIGN KEY(streaming_id) REFERENCES streaming(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_category FOREIGN KEY(category_id) REFERENCES category(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FK_videogame FOREIGN KEY(videogame_id) REFERENCES videogame(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ticket (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    type VARCHAR(255),
    price DOUBLE PRECISION,
    sale_comission INTEGER,
    stage VARCHAR(255),
    active BOOLEAN,
    "user" VARCHAR(255),
    tournament_id VARCHAR(255),
    CONSTRAINT FK_tournament FOREIGN KEY(tournament_id) REFERENCES tournament(id) ON DELETE CASCADE ON UPDATE CASCADE
);