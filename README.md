# 🏦 Sistema de Gestión Bancaria (SGB)

## 📚 Información General

* **Asignatura:** Programación Orientada a Objetos
* **Tema:** Clases Abstractas, Interfaces, Excepciones, Herencia y Polimorfismo
* **Lenguaje:** Java 17+

---

## 👨‍💻 Integrantes

* Reinel Pupo Morelo
* Melani Johana Polo Beltran
* Alexander Polo Narvaez
* Emiliano Perez Meza

---

## 🎯 Descripción del Proyecto

Este proyecto consiste en el desarrollo de un **Sistema de Gestión Bancaria (SGB)** que permite administrar clientes, cuentas, empleados y transacciones, aplicando correctamente los principios de la Programación Orientada a Objetos.

El sistema incluye:

* Gestión de clientes naturales y empresariales
* Manejo de diferentes tipos de cuentas
* Registro de transacciones (depósitos, retiros y transferencias)
* Administración de empleados
* Control mediante excepciones personalizadas
* Uso de interfaces como contratos de comportamiento

---

## 🧱 Estructura del Proyecto

```
/src
 ├── modelo
 │    ├── abstractas
 │    ├── personas
 │    ├── empleados
 │    ├── cuentas
 │    ├── banco
 │    ├── interfaces
 │    ├── excepciones
 │    ├── enums
 │
 ├── principal

/docs

README.md
```

---

## 📊 Diagramas UML

Ubicados en la carpeta `/docs`:

* ✔ Diagrama de Casos de Uso
* ✔ Diagrama de Clases

---

## 📖 Historias de Usuario (Product Backlog)

| ID    | Historia                      | Criterios de Aceptación                            | Prioridad | Puntos |
| ----- | ----------------------------- | -------------------------------------------------- | --------- | ------ |
| HU-01 | Registrar cliente natural     | Validación de documento único y datos obligatorios | Alta      | 5      |
| HU-02 | Registrar cliente empresarial | Validación de NIT y datos completos                | Alta      | 5      |
| HU-03 | Abrir cuenta                  | Asociación de cuenta a cliente                     | Alta      | 5      |
| HU-04 | Realizar depósito             | Validar estado de cuenta                           | Alta      | 3      |
| HU-05 | Realizar retiro               | Validar saldo suficiente                           | Alta      | 5      |
| HU-06 | Transferir dinero             | Validar cuentas y saldo                            | Alta      | 8      |
| HU-07 | Consultar cliente             | Mostrar información resumida                       | Media     | 3      |
| HU-08 | Bloquear cuenta               | Cambiar estado correctamente                       | Media     | 4      |
| HU-09 | Aprobar crédito               | Solo gerente puede ejecutar                        | Alta      | 6      |
| HU-10 | Calcular nómina               | Uso de polimorfismo                                | Media     | 4      |
| HU-11 | Notificar cliente             | Validar si acepta notificaciones                   | Baja      | 2      |
| HU-12 | Auditoría de cambios          | Registro de modificaciones                         | Media     | 3      |

---

## ⚙️ Funcionalidades Implementadas

### 👤 Gestión de Clientes

* Registro de clientes naturales y empresariales
* Asociación de hasta 5 cuentas por cliente
* Notificaciones personalizadas

### 💳 Gestión de Cuentas

* Cuenta Corriente
* Cuenta de Ahorros
* Cuenta de Crédito
* Cálculo de intereses
* Bloqueo y desbloqueo

### 💸 Gestión de Transacciones

* Depósitos
* Retiros
* Transferencias
* Validación de estados

### 👨‍💼 Gestión de Empleados

* Cajeros
* Asesores financieros
* Gerentes
* Cálculo de salarios y bonificaciones

---

## 🔴 Manejo de Excepciones

### ✔ Excepciones Checked

* SaldoInsuficienteException
* CuentaBloqueadaException
* ClienteNoEncontradoException
* CapacidadExcedidaException

### ✔ Excepciones Unchecked

* DatoInvalidoException
* EstadoTransaccionInvalidoException
* PermisoInsuficienteException

---

## 🔵 Interfaces Implementadas

* Consultable
* Transaccionable
* Auditable
* Notificable

---

## 🟡 Enumeraciones

* EstadoTransaccion
* TipoCuenta
* Turno
* TipoDocumento

---

## 🖥️ Ejecución del Sistema

La clase principal `SistemaBancarioDemo.java` demuestra:

1. Registro de clientes
2. Creación de cuentas
3. Depósitos y manejo de errores
4. Retiros con validaciones
5. Transferencias
6. Polimorfismo en empleados
7. Polimorfismo en cuentas
8. Manejo de errores en transacciones
9. Control de permisos
10. Notificaciones
11. Auditoría
12. Cálculo de nómina

---

## 🔧 Requisitos Técnicos

* ✔ Uso de Java 17 o superior
* ✔ Uso de `LocalDate` y `LocalDateTime`
* ✔ Arrays estáticos
* ✔ Uso de `super()` en herencia
* ✔ Encapsulamiento con validaciones
* ❌ No uso de `ArrayList` o colecciones
* ❌ No uso de `var`
* ❌ No uso de frameworks externos

---

## ✅ Lista de Verificación

* ✔ Clases abstractas implementadas
* ✔ Interfaces correctamente aplicadas
* ✔ Excepciones personalizadas creadas
* ✔ Polimorfismo aplicado
* ✔ Validaciones en setters
* ✔ Diagramas UML incluidos
* ✔ Código compilable y funcional

---

## 🚀 Instrucciones de Ejecución

1. Clonar el repositorio
2. Abrir el proyecto en el IDE (IntelliJ, Eclipse o NetBeans)
3. Ejecutar la clase `SistemaBancarioDemo.java`
4. Ver resultados en consola

---

## 🎥 (Opcional)

Se incluye video demostrativo mostrando:

* Ejecución del sistema
* Manejo de excepciones

---

## 📌 Conclusión

Este proyecto demuestra la correcta aplicación de los principios de la Programación Orientada a Objetos, integrando conceptos como herencia, polimorfismo, encapsulamiento, uso de interfaces y manejo de excepciones dentro de un sistema realista.

---
