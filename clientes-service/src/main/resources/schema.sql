-- Create clientes table
CREATE TABLE IF NOT EXISTS clientes (
  id SERIAL PRIMARY KEY,
  full_name VARCHAR(160) NOT NULL,
  documento VARCHAR(60) NOT NULL,
  telefono VARCHAR(20)
);

-- Insert demo data
INSERT INTO clientes (full_name, documento, telefono) VALUES
  ('Juan Pérez', '1234567890', '3001234567'),
  ('María López', '0987654321', '3109876543')
ON CONFLICT DO NOTHING;

