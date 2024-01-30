# Encuesta Dieta
Se han realizado ciertos cambios en el codigo para lograr cambiar toda la estructura de arbol a listas
___
## Clases Actualizadas
### Paciente
Los cambios en el codigo de la clase Paciente han sido muy basicos, unicamente he actualizado la estructura de Tree a List para ello el cambio ha sido:
*List<DiaAlimentacion>*, además he actualizado la forma de busquedaDiaAlimentacion para que se recorra toda la lista.
___
### DiaAlimentacion
Pasa igual que en paciente, anteriormente se recorria con una estructura de arbol, ahora se cambio a lista: List<Ingesta>.
___
### Tree Y TreeNode
Estas clases eran mas tecnicas y se encargaban de manejar una estructura en arbol, han sido eliminadas del programa porque ya no tienen utilidad.
___
### EncuestaAlimentaria
Esta clase ha presentado problemas a la hora de mostrar el resumen final, se ha actualizado dicho metodo para que siga una estructura de lista.
___
### Mas
Mencionar que el programa base tenia una estructura de arbol, pero la clase ingesta y alimento estaba bajo una estructura de listas, 
por lo tanto no ha sido necesario actualizar nada de dichas clases.
Por otro lado, mencionar que el ejercicio mantiene las bases anteriores y la interfaz sigue siendo la misma.
