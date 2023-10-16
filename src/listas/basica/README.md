# Lista básica

<div align=center>

||
|-|
![](/imagenes/modelosUML/listaBasica.svg)

</div>

## Nodo: clase Node

Un nodo sabe quién es y el nodo que le sigue.

||||
|-|-|-|
|Constructor|`public Node(String value) {}`
|Obtener dato|`public String getvalue() {}`
|Definir dato|`public void setValue(String newValue) {}`
|Devolver el siguiente|`public Node getNext() {}`
|Definir el siguiente|`public void setNext(Node next) {}`

## Lista: clase List

Una lista gestiona los nodos (CRUD). Adicionalmente, puede 

||||
|-|-|-|
|Constructor|∄ como tal.
|Número de nodos|`public int size() {}`
|Ver si está vacía|`public boolean isEmpty() {}`
|Insertar elemento|`public void insert(String value) {}`
|Eliminar elemento|`public void delete() {}`
|Listar los elementos|`public String[] listAll() {}`
