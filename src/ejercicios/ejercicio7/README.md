# Partido de Fútbol CDM – Apuestas
La empresa CDM festeja sus 30 años de existencia con un porra sobre la celebración de un partido de fútbol entre los equipos DM2 – PRF 
(No se han publicado las alineaciones de cada equipo para disponer de algo de variedad en las apuestas, debido a la superioridad del equipo 
PRF sobre el resto de rivales).

En dicha porra participarán los NUM_EMPLEADOS (hilos) de la empresa. Para ello realizarán el siguiente procedimiento:
* leen de la porra el importe actual
* esperan un pequeño tiempo aleatorio (100 ~ 300 ms.)
* generamos un resultado aleatorio teniendo en cuenta que:
    * DM2 nunca ha metido más de MAX_GOLES~4 goles en ningún partido de su historia
    * PRF no quiere abusar de su calidad y se compromete a no meter más de MAX_GOLES
    * cada empleado apuesta 1€ cada vez (MEJORA: incrementa en cada apuesta en 1€)

Cada empleado realizará NUM_APUESTAS_EMPLEADO (~ 5)

Finalmente se juega el partido y se visualizarán los resultados:
* del partido
* total de € ingresados (~ de apuestas)
* empleados que ganaron la porra
* cuánto le toca a cada uno
