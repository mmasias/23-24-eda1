# Programación genérica

## ¿Por qué?

La diversidad y variabilidad de los tipos de datos con los que trabajan las aplicaciones modernas es vasta, y el desarrollo de algoritmos y estructuras de datos para cada tipo de información es redundante y contraproducente. Surge de aquí la necesidad de escribir código que sea independiente del tipo de dato con el que opera, pero que al mismo tiempo, mantenga la seguridad y la robustez del tipo.

## ¿Qué?

La programación genérica se refiere a la definición de clases, interfaces y métodos de manera que puedan operar en tipos de datos aún no especificados. Estos tipos se determinan posteriormente cuando se utiliza o instancia dicha clase o método. En Java, la programación genérica se introdujo para proporcionar mecanismos de tipo seguro sin comprometer el rendimiento del programa, permitiendo la reutilización de código y la reducción de errores en tiempo de ejecución.

## ¿Para qué?

|||
|-|-|
Reutilización de código|Evita la duplicación de código al permitir la definición de algoritmos que funcionen de manera general para diferentes tipos.
Seguridad de tipo|Aumenta la robustez del código al detectar posibles errores de tipo en tiempo de compilación en lugar de en tiempo de ejecución.
Rendimiento mejorado|Al conocer los tipos en tiempo de compilación, el compilador Java puede realizar optimizaciones específicas, en contraposición a las técnicas de "todo es un objeto" que podrían afectar el rendimiento.
Flexibilidad|Ofrece la capacidad de adaptar código a nuevas situaciones sin reescribir o modificar las estructuras originales.

## ¿Cómo?

La programación genérica en Java se implementa mediante el uso de "type parameters" (parámetros de tipo). Estos parámetros de tipo actúan como marcadores para los tipos reales que se utilizarán cuando se instancia una clase o se invoca un método.

### Definición de clases e interfaces genéricas

```java
public class Box<T> {
    private T t;
    public void set(T t) { 
        this.t = t; 
    }
    public T get() { 
        return t; 
    }
}
```

### Utilización de Clases Genéricas:

Crear un objeto de una clase genérica especificando el tipo real:

```java
Box<Integer> integerBox = new Box<Integer>();
Box<String> stringBox = new Box<>();

```

### Métodos Genéricos:

Similar a las clases genéricas, pero aplicado a métodos:

```java
public static <U> void displayBoxContent(Box<U> box) {
    U content = box.get();
    System.out.println(content);
}
```

### Wildcards

Son útiles en situaciones donde es necesario referirse a objetos genéricos sin conocer el tipo exacto:

```java
public void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}
```

### Limitaciones y Bounded Types

Se pueden aplicar restricciones a los tipos que se pueden utilizar como parámetros de tipo. Por ejemplo, limitar un tipo a ser una subclase de otro:

```java
public class NumericBox<T extends Number> {
    // implementación...
}
```
