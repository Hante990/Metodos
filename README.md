# 🧮 Tema 1: Errores Numéricos

Este repositorio contiene ejercicios y ejemplos prácticos implementados en Java para entender y visualizar los distintos tipos de errores que se presentan al trabajar con métodos numéricos. El enfoque principal está en los **errores de truncamiento**, **errores de aproximación** y el temido **overflow**.

---

## 📑 Índice

- [📄 Descripción del Tema](#descripción-del-tema)
- [📚 Sobre la Materia](#sobre-la-materia)
  - [🎯 Competencia de la Asignatura](#competencia-de-la-asignatura)
  - [🔍 Competencia del Tema](#competencia-del-tema)
  - [📌 Temario](#temario)
- [🧪 Tipos de Errores Numéricos](#tipos-de-errores-numéricos)
  - [✂️ Error de Truncamiento](#error-de-truncamiento)
  - [📉 Error de Aproximación](#error-de-aproximación)
  - [💥 Overflow](#overflow)

---

## 📄 Descripción del Tema <a name="descripción-del-tema"></a>

Los errores son inherentes a los métodos numéricos debido a la forma en que las computadoras representan números. Este tema permite comprender su origen, cómo se manifiestan y cómo pueden minimizarse.

---

## 📚 Sobre la Materia <a name="sobre-la-materia"></a>

### 🎯 Competencia de la Asignatura <a name="competencia-de-la-asignatura"></a>

Aplica los métodos numéricos para resolver problemas científicos y de ingeniería utilizando
la computadora.

### 🔍 Competencia del Tema <a name="competencia-del-tema"></a>

Aplica los tipos de errores para identificar la incertidumbre y limitaciones de los cálculos numéricos en una computadora.

### 📌 Temario <a name="temario"></a>

- Error de Truncamiento
- Error de Aproximación
- Overflow (desbordamiento)

---

## 🧪 Tipos de Errores Numéricos <a name="tipos-de-errores-numéricos"></a>

### ✂️ Error de Truncamiento <a name="error-de-truncamiento"></a>

**Descripción:**  
Este tipo de error ocurre cuando se detiene un cálculo numérico en un número finito de pasos, ignorando términos menores. Es común en series infinitas, derivadas y métodos iterativos.

**Ejemplo: Aproximación de `e^x` usando una serie de Taylor:**

**Pseudocódigo**
```plaintext
Función expTaylor(x, n)
    sum ← 1.0
    term ← 1.0

    Para i desde 1 hasta n hacer
        term ← term * (x / i)
        sum ← sum + term
    Fin Para

    Retornar sum
Fin Función
```
**Código java**
```java
public static double expTaylor(double x, int n) {
    double sum = 1.0;
    double term = 1.0;

    for (int i = 1; i <= n; i++) {
        term *= x / i;
        sum += term;
    }

    return sum;
}
```
**Resultado**

![image](https://github.com/user-attachments/assets/6735d681-7eb0-4ea9-bca6-f872efc33d37)

### 📉 Error de Aproximación <a name="error-de-aproximación"></a>

**Descripción:**  
Este error se presenta cuando se utilizan representaciones limitadas de los números reales en la computadora. Por ejemplo, representar 1/3 como 0.333....

**Ejemplo: Restar dos números muy cercanos (cancelación)**

**Pseudocódigo**
```plaintext
Inicio
    a ← 1.0000001
    b ← 1.0000000

    result ← (a - b) / (a + b)

    Escribir "Resultado: " + result
Fin
```

**Código Java**
```java
double a = 1.0000001;
double b = 1.0000000;
double result = (a - b) / (a + b);
System.out.println("Resultado: " + result);
```
**Resultado**

![image](https://github.com/user-attachments/assets/271bb500-7e85-4067-a4d4-5fb3d4d1e8d0)

### 💥 Overflow <a name="overflow"></a>

**Descripción:**  
Ocurre cuando se intenta representar un número fuera del rango que la variable puede manejar. Puede causar errores de ejecución o resultados inesperados.

**Ejemplo: Aproximación de `e^x` usando una serie de Taylor:**

**Pseudocódigo**
```plaintext
Función factorial(n)
    result ← 1
    Para i desde 2 hasta n hacer
        result ← result * i
    Fin Para
    Retornar result
Fin Función
```

**Código Java**
```java
public static long factorial(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}
```
**Resultado**

![image](https://github.com/user-attachments/assets/d4c2a1dd-055e-4da8-96d0-0c37b670f3d9)


