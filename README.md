# 📘 Solución de Ecuaciones

Este repositorio contiene una recopilación de ejercicios desarrollados como parte del curso de **Métodos Numéricos**, específicamente enfocados en la **solución de ecuaciones no lineales** mediante métodos numéricos. Aquí encontrarás implementaciones, explicaciones y ejemplos prácticos en Java para los métodos más utilizados.

---

## 📑 Índice

- [📄 Descripción del Problemario](#descripcion-del-problemario)
- [📚 Sobre la Materia](#sobre-la-materia)
  - [🎯 Competencia de la Asignatura](#competencia-de-la-asignatura)
  - [🔍 Competencia del Tema](#competencia-del-tema)
  - [📌 Temario](#temario)
- [🧮 Métodos Numéricos para Encontrar las Raíces](#metodos-numericos-para-encontrar-las-raices)
  - [📏 Método de Bisección](#metodo-de-biseccion)
  - [📐 Método de la Falsa Posición](#metodo-de-la-falsa-posicion)
  - [📈 Método de la Secante](#metodo-de-la-secante)
  - [⚡ Método de Newton-Raphson](#metodo-de-newton-raphson)
- [👨‍💻 Autor](#autor)

---

## 📄 Descripción del Problemario <a name="descripcion-del-problemario"></a>

En esta sección se presentan diversos ejercicios implementados en Java para resolver ecuaciones no lineales, utilizando los siguientes métodos numéricos:

1. 📏 **Bisección**
2. 📐 **Falsa Posición**
3. 📈 **Secante**
4. ⚡ **Newton-Raphson**

Cada ejercicio incluye descripción, pasos generales del método, y el código correspondiente.

---

## 📚 Sobre la Materia <a name="sobre-la-materia"></a>

### 🎯 Competencia de la Asignatura <a name="competencia-de-la-asignatura"></a>

Aplicar métodos numéricos para resolver problemas científicos y de ingeniería utilizando la computadora.

### 🔍 Competencia del Tema <a name="competencia-del-tema"></a>

Utilizar métodos numéricos con el objetivo de solucionar ecuaciones mediante técnicas de intervalo e interpolación, apoyándose en un lenguaje de programación.

### 📌 Temario <a name="temario"></a>

- Método de Bisección
- Método de Falsa Posición
- Método de la Secante
- Método de Newton-Raphson

---

## 🧮 Métodos Numéricos para Encontrar las Raíces <a name="metodos-numericos-para-encontrar-las-raices"></a>

### 📏 Método de Bisección <a name="metodo-de-biseccion"></a>

**Descripción:**  
El método de bisección es una técnica iterativa que permite encontrar una raíz dentro de un intervalo en el cual la función cambia de signo. Se basa en dividir repetidamente el intervalo a la mitad hasta alcanzar la precisión deseada.

**Pasos Generales:**
1. Definir un intervalo `[a, b]` donde `f(a) * f(b) < 0`.
2. Calcular el punto medio `c = (a + b) / 2`.
3. Evaluar `f(c)` y determinar el nuevo subintervalo.
4. Repetir hasta que el error sea menor al permitido.

**Código en Java:**
```java
// Bisección en Java
public static double bisection(double a, double b, double error) {
    while ((b - a) / 2 > error) {
        double c = (a + b) / 2;
        if (f(c) == 0) return c;
        if (f(a) * f(c) < 0) b = c;
        else a = c;
    }
    return (a + b) / 2;
}
public static double f(double x) {
    return x * x - 4;
}
```
### 📐 Método de la Falsa Posición <a name="metodo-de-la-falsa-posicion"></a>

**Descripción:**  
También conocido como "regula falsi", este método mejora la convergencia del método de bisección utilizando una aproximación lineal entre los puntos del intervalo.

**Pasos Generales:**
1. Definir un intervalo `[a, b]` donde `f(a) * f(b) < 0`.
2. Calcular el punto `c` usando la fórmula de interpolación lineal.
3. Evaluar `f(c)` y determinar el nuevo subintervalo.
4. Repetir hasta que el error sea menor al permitido.

**Código en Java:**
```java
// Falsa Posición en Java
public static double falsePosition(double a, double b, double error) {
    double c = a;
    while (Math.abs(f(c)) > error) {
        c = (a * f(b) - b * f(a)) / (f(b) - f(a));
        if (f(c) == 0) break;
        if (f(a) * f(c) < 0) b = c;
        else a = c;
    }
    return c;
}
```
### 📈 Método de la Secante  <a name="metodo-de-la-secante"></a>

**Descripción:**  
El método de la secante es una variante del método de Newton-Raphson que no requiere el cálculo de la derivada. Utiliza una aproximación basada en dos puntos anteriores.

**Pasos Generales:**
1. Seleccionar dos puntos iniciales x0 y x1.
2. Calcular el siguiente punto usando la fórmula de la secante.
3. Actualizar los puntos anteriores con los nuevos valores.
4. Repetir hasta que el error sea menor al permitido.

**Código en Java:**
```java
// Secante en Java
public static double secant(double x0, double x1, double error) {
    double x2;
    do {
        x2 = x1 - (f(x1) * (x1 - x0)) / (f(x1) - f(x0));
        x0 = x1;
        x1 = x2;
    } while (Math.abs(f(x2)) > error);
    return x2;
}
```
### ⚡ Método de Newton-Raphson <a name="metodo-de-newton-raphson"></a>

**Descripción:**  
Este método iterativo utiliza la derivada de la función para converger más rápidamente a la raíz. Es uno de los métodos más eficientes cuando se tiene una buena aproximación inicial.

**Pasos Generales:**
1. Elegir un punto inicial x0.
2. Calcular el siguiente punto usando la fórmula de Newton-Raphson.
3. Repetir hasta que el error sea menor al permitido.

**Código en Java:**
```java
// Newton-Raphson en Java
public static double newtonRaphson(double x0, double error) {
    double x1;
    do {
        x1 = x0 - f(x0) / df(x0);
        x0 = x1;
    } while (Math.abs(f(x1)) > error);
    return x1;
}

public static double df(double x) {
    return 2 * x; // Derivada de f(x) = x² - 4
}
```
