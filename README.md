# SCC-1017 Métodos Numéricos
## Unidad 3 - Práctica: Método de Gauss

Este repositorio contiene la solución práctica de la eliminación de Gauss para sistemas de ecuaciones lineales de \(3 \times 3\), desarrollada bajo un enfoque de programación modular y con un diseño de matriz visible incrustado directamente en el código fuente.

* **Docente:** Víctor Hugo Vásquez Herrera
* **Institución:** Instituto Tecnológico Superior de Xalapa
* **Carrera:** Ingeniería en Sistemas Computacionales

---

### 🛠️ Lenguaje de Programación Utilizado
* **Java** (Versión 8 o superior)
* Paradigma orientado a objetos con un enfoque estrictamente modular.

---

### 📂 Estructura del Código Fuente
El programa se encuentra en el archivo `MetodoGauss.java` y está dividido en tres módulos clave separados de forma lógica:
1. `main(String[] args)`: Punto de entrada que define la matriz inicial \(3 \times 3\) visible e invoca las funciones de resolución y renderizado.
2. `resolverGauss(double[][] matriz)`: Módulo matemático que realiza la eliminación hacia adelante (triangularización superior con pivoteo parcial) y la sustitución hacia atrás.
3. `imprimirMatriz(double[][] matriz)`: Módulo de interfaz gráfica por consola encargado de formatear y dibujar la matriz de forma limpia utilizando una barra vertical `|` para separar los términos independientes.

---

### 🚀 Pasos para Compilar y Ejecutar

Abre una terminal de comandos en la carpeta raíz donde guardaste el archivo `MetodoGauss.java` y ejecuta las siguientes instrucciones:

1. **Compilar el código fuente:**
   ```bash
   javac MetodoGauss.java
   ```

2. **Ejecutar el programa compiled:**
   ```bash
   java MetodoGauss
   ```

---

### 🖥️ Ejemplo de Prueba y Salida en Consola

Al ejecutar el programa, se procesa automáticamente el siguiente sistema predefinido:
* \(2x + 1y - 1z = 8\)
* \(-3x - 1y + 2z = -11\)
* \(-2x + 1y + 2z = -3\)

#### Salida real obtenida:
```text
=== MATRIZ INICIAL (SISTEMA DE ECUACIONES) ===
[     2.00     1.00    -1.00 |     8.00 ]
[    -3.00    -1.00     2.00 |   -11.00 ]
[    -2.00     1.00     2.00 |    -3.00 ]

=== MATRIZ TRIANGULAR SUPERIOR OBTENIDA ===
[    -3.00    -1.00     2.00 |   -11.00 ]
[     0.00     1.67     3.33 |   -10.33 ]
[     0.00     0.00     1.40 |    -2.80 ]

=== SOLUCIÓN DEL SISTEMA ===
x = 2.0000
y = -1.0000
z = -2.0000
```