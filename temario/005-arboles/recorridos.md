# Árboles - Recorridos

La diferencia entre estos tres recorridos radica básicamente en la forma como se exploran los dos hijos de cada vértice.

<div align=center>

||![](/imagenes/modelosUML/arboles001.png)||
|:-:|:-:|:-:|
**Preorden**|**Inorden**|**Postorden**
V / hI / hD|hI / V / hD|hI / hD / V

</div>

## Preorden

Para recorrer un árbol binario en preorden se comienza por la raíz y luego se recorre en preorden el subárbol que tiene como raíz el hijo izquierdo de la raíz del árbol original. Una vez recorrido todos los vértices del subárbol izquierdo se recorre en preorden el subárbol derecho. En otras palabras, por cada vértice se registra primero el vértice, luego el hijo izquierdo y finalmente el hijo derecho.

## Inorden

Para recorrer un árbol binario en inorden se comienza por recorrer en inorden el subárbol que tiene como raíz el hijo izquierdo de la raíz del árbol original. Una vez recorrido todos los vértices del subárbol izquierdo se visita la raíz y luego se recorre en inorden el subárbol derecho. En otras palabras, por cada vértice se registra primero el hijo izquierdo, luego el vértice y finalmente el hijo derecho.

## Postorden

Para recorrer un árbol binario en postorden se comienza por recorrer en postorden el subárbol que tiene como raíz el hijo izquierdo de la raíz del árbol original. Una vez recorrido todos los vértices del subárbol izquierdo, se recorre en postorden el subárbol derecho y finalmente se visita la raíz. En otras palabras, por cada vértice se registra primero el hijo izquierdo, luego el hijo derecho y finalmente el vértice.



<div align=center>

|![](/imagenes/modelosUML/arboles001.png)|
|-|

||||
|-|-|-|
Preorden|`{a, b, d, e, h, i, c, f, g, j, k}`|V / hI / hD
Inorden|`{d, b, h, e, i, a, f, c, j, g, k}`|hI / V / hD
Postorden|`{d, h, i, e, b, f, j, k, g, c, a}`|hI / hD / V


</div>