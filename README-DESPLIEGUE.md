# 🚀 Guía de Despliegue en Render - Sistema de Parqueadero

## 📋 Lo que necesito de ti

### 1️⃣ Nombre del Repositorio en GitHub

Cuando subas el código a GitHub, ponle este nombre al repositorio:

```
parqueadero-microservicios
```

O el nombre que prefieras, pero **dime cuál es** para configurar el despliegue.

### 2️⃣ Crear Base de Datos en Render

1. Ve a https://dashboard.render.com
2. Click en **"New +"** → **"PostgreSQL"**
3. Configura:
   - **Name**: `parqueadero-db`
   - **Database**: `parqueadero` 
   - **User**: `parqueadero_user`
   - **Region**: Oregon (US West)
   - **Plan**: Free
4. Click **"Create Database"**
5. Espera a que el estado sea **"Available"** (~2-3 minutos)

### 3️⃣ Dame estos 3 datos de conexión

Una vez la base de datos esté lista, en la sección **"Connections"**, cópiame:

```
1. Internal Database URL: postgresql://...
2. Username: ...
3. Password: ...
```

**Eso es todo.** Con esos datos yo configuro el `render.yaml` y te digo cómo desplegarlo.

---

## 🎯 Después del despliegue - Endpoints disponibles

Una vez desplegado, obtendrás una URL del API Gateway (ej: `https://api-gateway-xxxx.onrender.com`)

### Clientes
- `GET /api/players` - Listar clientes
- `GET /api/players/{id}` - Obtener cliente por ID
- `POST /api/players` - Crear cliente
- `PUT /api/players/{id}` - Actualizar cliente
- `DELETE /api/players/{id}` - Eliminar cliente

**Ejemplo JSON para crear cliente:**
```json
{
  "fullName": "Juan Pérez",
  "documento": "1234567890",
  "telefono": "3001234567"
}
```

### Vehículos
- `GET /api/teams` - Listar vehículos
- `GET /api/teams/{id}` - Obtener vehículo por ID
- `POST /api/teams` - Crear vehículo
- `PUT /api/teams/{id}` - Actualizar vehículo
- `DELETE /api/teams/{id}` - Eliminar vehículo

**Ejemplo JSON para crear vehículo:**
```json
{
  "placa": "ABC123",
  "marca": "Toyota",
  "modelo": "Corolla",
  "clienteId": 1
}
```

---

## 📊 Tablas que se crean automáticamente

### Clientes
```sql
CREATE TABLE clientes (
  id SERIAL PRIMARY KEY,
  full_name VARCHAR(160) NOT NULL,
  documento VARCHAR(60) NOT NULL,
  telefono VARCHAR(20)
);
```

### Vehículos
```sql
CREATE TABLE vehiculos (
  id SERIAL PRIMARY KEY,
  placa VARCHAR(10) NOT NULL,
  marca VARCHAR(50) NOT NULL,
  modelo VARCHAR(50) NOT NULL,
  cliente_id INT
);
```

Las tablas se crean automáticamente con datos de ejemplo al iniciar los servicios.

---

**Resumen:** Solo necesito el **nombre del repo** y los **datos de conexión de la BD**. Yo me encargo del resto.

