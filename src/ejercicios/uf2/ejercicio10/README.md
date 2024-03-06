# Ejercicio 10
## Realiza un CRUD contra los servicios del API rest CLIENTES.

> Para compilar este programa son necesarias la librería jackson-databind.

###Obtener todos los clientes
~~~
GET http://ip_servidor:8080/api/clientes

RESPUESTA

[

{

"codCliente": 1,

"nombre": "Nombre",

"codProvincia" : 1,

"vip" : 1

},

{

...

}

]
~~~
### Obtener un cliente
~~~
GET http://ip_servidor:8080/api/clientes/{id}

RESPUESTA

{

    "codCliente":1,

    "nombre":"María",

    "codProvincia":1,

    "vip":1

}
~~~
### Insertar un cliente
~~~
POST http://ip_servidor:8080/api/clientes

PAYLOAD

{

    "nombre": "Nombre",

    "codProvincia" : 1,

    "vip" : 1

}
~~~
### Actualizar un cliente
~~~
PUT http://ip_servidor:8080/api/clientes/{id}

PAYLOAD

{

"nombre": "Nombre",

"codProvincia" : 1,

"vip" : 1

}
~~~
### Eliminar un cliente
~~~
DELETE http://ip_servidor:8080/api/clientes/{id}
~~~
