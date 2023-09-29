package ejemplos.crearhilos;

/**
 * Podemos crear hilos utilizando objetos que implementen Runnable.
 * La forma de hacerlo es pasándole este objeto al constructor de {@link Thread#Thread(java.lang.Runnable) }<br>
 * <pre>
 *  Thread hilo = new Thread(new HiloRunnable("nombre", espera");
 *  //Aqui lanzamos el hilo
 *  hilo.start();
 * </pre>
 * @author Samuel Loureiro Cardoso
 */
public class HiloRunnable implements Runnable{
    private int time;
    private String name;
    
    /**
     * Crea un objeto HiloRunnable que al ser ejecutado realizará una tarea
     * que tarde un tiempo determinado.
     * @param nombre Nombre del hilo.
     * @param time Tiempo en milisegundos que tarda en ejecutar la tarea.
     */
    public HiloRunnable(String nombre, int time){
        this.name = nombre;
        this.time = time;
    }
    
    /**
     * Simula la ejecución de una tarea que tarda un tiempo determinado. <br>
     * Imprime por consola: Soy <i>nombre del hilo</i>. Hago una cosa.
     * Cuando termine muestra por la salida de error (en rojo): Soy <i>nombre del hilo</i>. Terminé. 
     */
    @Override
    public void run() {
        try {
            System.out.println("Soy "+this.name+". Hago una cosa.");
            Thread.sleep(time);
            System.err.println("Soy "+this.name+". Terminé.");
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }

}
