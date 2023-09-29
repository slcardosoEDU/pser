# Ejercicio 2: Cambio de un dato común por parte de varios hilos
Realice una aplicación que cree NUM_HILOS hilos que incrementen NUM_INCREMENTOS un dato común.  
Al final se visualizará el valor del dato verificando si su valor es NUM_HILOS*NUM_INCREMENTOS.

## Problemas que se pueden dar:
* Se crea un dato para cada hilo, no uno común
* Se visualiza el valor en el hilo principal antes de que acaben todos los incrementos
* Sin código sincronizado no se puede asegurar que se incremente de manera correcta.
