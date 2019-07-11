CREATE TABLE songs(
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  genre VARCHAR(255),
  release_year INTEGER,
  explicit BOOLEAN
);