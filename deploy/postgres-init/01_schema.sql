-- Tablas base
CREATE TABLE IF NOT EXISTS teams (
  id SERIAL PRIMARY KEY,
  name VARCHAR(120) NOT NULL,
  city VARCHAR(120) NOT NULL
);

CREATE TABLE IF NOT EXISTS players (
  id SERIAL PRIMARY KEY,
  full_name VARCHAR(160) NOT NULL,
  position VARCHAR(60) NOT NULL,
  team_id INT REFERENCES teams(id) ON DELETE SET NULL
);

-- Datos demo
INSERT INTO teams (name, city) VALUES
  ('Tigres', 'Armenia'),
  ('Cóndores', 'Pereira')
ON CONFLICT DO NOTHING;

INSERT INTO players (full_name, position, team_id) VALUES
  ('Juan Pérez', 'Delantero', 1),
  ('Luis Gómez', 'Defensa', 2)
ON CONFLICT DO NOTHING;
