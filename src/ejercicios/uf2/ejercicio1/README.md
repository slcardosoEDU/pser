# Servidor echo con 1 cliente
Implementar un servidor echo, donde un cliente se conecta, envía una cadena de texto y el servidor devuelve la misma cadena que recibe (echo).

Cuando recibe la cadena “fin” (ignorando may/min), finaliza.

En este primer ejemplo, el servidor acepta una única conexión (el método accept() no está en un
bucle), por lo que espera la conexión de un cliente y cuando este finaliza la conexión el servidor se cierra.
