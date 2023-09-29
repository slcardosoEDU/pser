# Problema del Comecocos 2
El **comecocos** es un juego infantil de papel que consiste en una pequeña papiroflexia [que se puede hacer con una hoja de papel](https://www.youtube.com/watch?v=fJp6fdftLpw).  
Para jugar, se hace girar la papiroflexia en la mano y se abre y cierra varias veces hasta que el jugador decide parar.
Luego, se abre el comecocos y se revela un mensaje o pregunta que el jugador debe responder.

## Desarrollo
Repetiremos el problema del comecocos, pero esta vez lanzaremos tanto el botón como el comecocos en
hilos independientes al hilo principal. La dificultad de este problema radica en como sincronizar
estos 3 hilos.
