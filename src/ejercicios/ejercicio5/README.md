
# Ejercicio: Llega el Jefe
En una oficina, los empleados (hilos) van llegando a la oficina y se ponen a trabajar… pero solo si ya ha llegado el jefe (el otro hilo), porque en caso contrario se ponen a dormir.

En cuanto llega el jefe, inmediatamente se ponen a trabajar sin que éste se de cuenta.



Simúlese la situación anterior, visualizando los mensajes adecuados para ver que se cumplen las condiciones indicadas. Los mensajes pueden ser:

{nombreEmpleado} ha llegado. ZZZZZZ  (si no está el jefe)
{nombreEmpleado} ha llegado. Hola jefe!, me pongo a trabajar...  (si ya está el jefe)
EL JEFE HA LLEGADO!  (dice el jefe gritando al llegar, por lo que despierta a todos)
({nombreEmpleado} desperazándose), buenos días jefe, aquí estoy trabajando  (si acaba de llegar el jefe)