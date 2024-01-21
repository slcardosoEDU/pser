# HUCHA
Los padres de una familia numerosa aportan a la hucha familiar semanalmente (por practicidad, simulémoslo con una vez cada ~ segundo) una cantidad de dinero INGRESO_HUCHA~10€.

Los NUM_HIJOS~5 son muy derrochadores, retirando cada cierto tiempo aleatorio (entre MIN_ESPERA y MAX_ESPERA ms.) y poco a poco (para que no se note mucho) dinero de la hucha en una progresión acumulada (1€,1€,2€,3€,5€,8€,13€...) que responde a la secuencia
`fn = fn-1 + fn-2; con f0=0 y f1=1`

Si un hijo va a quitar dinero a la hucha y no le llega, tendrá que esperar hasta que haya suficiente. Y mientras un hijo está esperando puede venir otro hijo y retirar dinero si a él sí le llega el que hay.

Con el tiempo los hijos van madurando y son conscientes de que no se puede derrochar el dinero así como así, por lo que al retirar NUM_RETIRADAS~10 veces dinero, dejan la hucha tranquila.

La aplicación visualizará todos los datos por pantalla de manera clara: qué hijo cogió dinero, en qué semana pasa cada movimiento de dinero, y terminará cuando todos los hijos hayan hecho sus retiradas, mostrando el dinero que ha quedado en la hucha.

La ejecución de la aplicación se realizará, en la medida de lo posible, de la manera más óptima en todos los aspectos: escritura y diseño del código, rendimiento CPU, etc.