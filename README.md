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

### 📐 Método de la Falsa Posición

**Descripción:**  
El método de la falsa posición, o regula falsi, es una técnica numérica para encontrar raíces. A diferencia de la bisección, usa una línea recta entre los extremos del intervalo para estimar una mejor aproximación de la raíz.

**Pasos Generales:**
1. Definir un intervalo [a, b] donde f(a) * f(b) < 0.
2. Calcular el punto c donde la línea entre (a, f(a)) y (b, f(b)) cruza el eje x.
3. Evaluar f(c) y determinar el nuevo subintervalo.
4. Repetir hasta alcanzar el error permitido.

**Código en Java:**
```java
// Falsa Posición en Java
public static double falsePosition(double a, double b, double error) {
    double fa = f(a), fb = f(b);
    if (fa * fb > 0) {
        System.out.println("No se garantiza una raíz en el intervalo.");
        return Double.NaN;
    }

    double c = a;
    while (Math.abs(b - a) > error) {
        c = (a * fb - b * fa) / (fb - fa);
        double fc = f(c);

        if (Math.abs(fc) < error) break;

        if (fa * fc < 0) {
            b = c;
            fb = fc;
        } else {
            a = c;
            fa = fc;
        }
    }
    return c;
}

public static double f(double x) {
    return x * x - 4;
}

### 📈 Método de la Secante

**Descripción:**  
El método de la secante es una técnica iterativa que, al igual que Newton-Raphson, busca aproximaciones sucesivas de la raíz. Sin embargo, no requiere calcular derivadas, sino que utiliza dos puntos iniciales y una recta secante.

**Pasos Generales:**
1. Seleccionar dos valores iniciales x0 y x1.
2. Calcular x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0)).
3. Repetir hasta que el error sea menor al permitido.

**Código en Java:**
```java
// Método de la Secante en Java
public static double secant(double x0, double x1, double error) {
    double f0 = f(x0), f1 = f(x1);
    double x2;

    while (Math.abs(x1 - x0) > error) {
        x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
        x0 = x1;
        f0 = f1;
        x1 = x2;
        f1 = f(x1);
    }
    return x1;
}

public static double f(double x) {
    return x * x - 4;
}

### ⚡ Método de Newton-Raphson

**Descripción:**  
Este método es rápido y eficiente, pero requiere conocer la derivada de la función. Parte de un valor inicial x0 y lo mejora sucesivamente usando la derivada hasta alcanzar una aproximación adecuada.

**Pasos Generales:**
1. Seleccionar un valor inicial x0.
2. Aplicar la fórmula: x1 = x0 - f(x0) / f'(x0)'.
3. Repetir el proceso hasta que el error sea menor al deseado.

**Código en Java:**
```java
// Método de Newton-Raphson en Java
public static double newtonRaphson(double x0, double error) {
    double x1;

    while (true) {
        double fx = f(x0);
        double dfx = df(x0);
        if (dfx == 0) {
            System.out.println("Derivada nula. El método no puede continuar.");
            return Double.NaN;
        }

        x1 = x0 - fx / dfx;

        if (Math.abs(x1 - x0) < error)
            break;

        x0 = x1;
    }
    return x1;
}

public static double f(double x) {
    return x * x - 4;
}

public static double df(double x) {
    return 2 * x;
}
