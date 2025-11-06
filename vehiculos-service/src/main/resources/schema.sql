-- Create vehiculos table
CREATE TABLE IF NOT EXISTS vehiculos (
  id SERIAL PRIMARY KEY,
  placa VARCHAR(10) NOT NULL,
  marca VARCHAR(50) NOT NULL,
  modelo VARCHAR(50) NOT NULL,
  cliente_id INT
);

-- Insert demo data
INSERT INTO vehiculos (placa, marca, modelo, cliente_id) VALUES
  ('ABC123', 'Toyota', 'Corolla', 1),
  ('XYZ789', 'Chevrolet', 'Spark', 2)
ON CONFLICT DO NOTHING;

