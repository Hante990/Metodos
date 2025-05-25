# 📘 Solución de Ecuaciones

Este repositorio contiene una recopilación de ejercicios desarrollados como parte del curso de **Métodos Numéricos**, específicamente enfocados en la **solución de ecuaciones no lineales** mediante métodos numéricos. Aquí encontrarás implementaciones, explicaciones y ejemplos prácticos en Java para los métodos más utilizados.

---

## 📑 Índice

- [📄 Descripción del Problemario](#descripción-del-problemario)
- [📚 Sobre la Materia](#sobre-la-materia)
  - [🎯 Competencia de la Asignatura](#competencia-de-la-asignatura)
  - [🔍 Competencia del Tema](#competencia-del-tema)
  - [📌 Temario](#temario)
- [🧮 Métodos Numéricos para Encontrar las Raíces](#métodos-numéricos-para-encontrar-las-raíces)
  - [📏 Método de Bisección](#método-de-bisección)
  - [📐 Método de la Falsa Posición](#método-de-la-falsa-posición)
  - [📈 Método de la Secante](#método-de-la-secante)
  - [⚡ Método de Newton-Raphson](#método-de-newton-raphson)
- [👨‍💻 Autor](#autor)

---

## 📄 Descripción del Problemario

En esta sección se presentan diversos ejercicios implementados en Java para resolver ecuaciones no lineales, utilizando los siguientes métodos numéricos:

1. 📏 **Bisección**
2. 📐 **Falsa Posición**
3. 📈 **Secante**
4. ⚡ **Newton-Raphson**

Cada ejercicio incluye descripción, pasos generales del método, y el código correspondiente.

---

## 📚 Sobre la Materia

### 🎯 Competencia de la Asignatura

Aplicar métodos numéricos para resolver problemas científicos y de ingeniería utilizando la computadora.

### 🔍 Competencia del Tema

Utilizar métodos numéricos con el objetivo de solucionar ecuaciones mediante técnicas de intervalo e interpolación, apoyándose en un lenguaje de programación.

### 📌 Temario

- Método de Bisección
- Método de Falsa Posición
- Método de la Secante
- Método de Newton-Raphson

---

## 🧮 Métodos Numéricos para Encontrar las Raíces

### 📏 Método de Bisección

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
