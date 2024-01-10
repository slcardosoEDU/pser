# Servidor echo con muchos clientes
Teniendo en cuenta el ejercicio anterior (Servidor echo con 1 cliente), realice una versión donde se puedan conectar muchos clientes.

Para ello se creará un nuevo hilo en el servidor con cada conexión TCP (punto a punto)

Se aceptarán dos comandos del cliente:

* fin: similar al ejercicio anterior, cierra la conexión del cliente y se cierra su hilo-socket del servidor
* shutdown: tira el servidor, pero continúa la conexión con su hilo-socket. Esto quiere decir que sigue funcionando, pero el servidor principal ha cerrado, por lo que no se aceptan nuevas peticiones de clientes. Se podría volver a arrancar el servidor de nuevo y abrir nuevos clientes sin problema (en ese momento, realmente habría dos procesos servidores abiertos (aunque solo uno escuchando/aceptando peticiones), porque un proceso no se cierra hasta que acaban todos sus hilos. De esta manera habría hilos del primer proceso e hilos del segundo.

La aplicación controlará las excepciones necesarias para dar los mensajes y comportamientos adecuados cuando se produzca algún problema (por ejemplo, que ejecute un cliente y no encuentre servidor escuchando)
