package problema.recreo;


/**
 * Reprenta el Comecocos que puede devolver mensajes.
 * @author Samuel Loureiro Cardoso
 */
public class Comecocos extends Thread{
    /**
     * Los 8 mensajes que puede devolver el Comecocos. <br>
     * Cada posición del array representa una cara del comecocos.
     * Los mensajes son
     * <pre>
     * [0] Eres genial!
     * [1] Lo vas a petar en PSER
     * [2] Null pointer excecption :D
     * [3] No es magia, es concurrencia
     * [4] Soy el mensaje 5.
     * [5] Te quedaste en la posición 5.
     * [6] No es lo mismo 2 procesos paralelos que 2 procesos para lelos
     * [7] Cuando llegas al final vuelves al principio
     * <pre>
     */
    private final static String[] MENSAJES ={"Eres genial!",
        "Lo vas a petar en PSER",
        "Null pointer excecption :D",
        "No es magia, es concurrencia",
        "Soy el mensaje 5.",
        "Te quedaste en la posición 5.",
        "No es lo mismo 2 procesos paralelos que 2 procesos para lelos",
        "Cuando llegas al final vuelves al principio"
        };
    /**
     * El tiempo de espera para que el comecocos cambie de posición.
     */
    private final static int DELAY_MS = 200;
    private int currentPos;
    private boolean stop;
    /**
     * Crea un Comecocos en su estado inicial. <br>
     * Es importante tener en cuenta que <strong>al crear el objeto no se crea un hilo
     * nuevo.</strong> Para lanzar el hilo hay que llamar al método {@link Thread#start()}
     */
    public Comecocos(){
        super();
        currentPos = 0;
        stop = false;
        
    }
    /**
     * Avanza en de posición en el Comecocos cada {@link #DELAY_MS}. <br>
     * Al lanzar el hilo esta tarea se ejecutará en paralelo. 
     */
    @Override
    public void run(){
        while(!stop){
            //Bonus track: un uso chulo del operador módulo para generar secuencias ciclicas de 
            //números consecutivos. Se suele usar para recorrer arrays de forma
            //circular.
            currentPos = (currentPos+1)%MENSAJES.length;
            try {
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
            
        }
    }
    
    /**
     * Detiene de forma adecuada la ejecución del hilo. <br>
     * Después de ejecutar este método el hilo morirá <i>de muerte natural</i>.
     */
    public void detener(){
        stop = true;
    }
    
    /**
     * Devuelve el mensaje en la posición actual del Comecocos. <br>
     * Este método puede invocarse aunque el hilo haya finalizado.<br>
     * <ul><li>Si se llama antes de lanzar el hilo siempre devolverá el mismo mensaje (Eres genial!).</li>
     * <li>Si se llama durante la ejecución del hilo devolverá el mensaje de la posición actual.</li>
     * <li>Si se llama después de que el hilo haya finalizado devolverá el último mensaje que
     * se haya seleccionado durante la ejecución del hilo.</li></ul>
     * @return Mensaje actual del comecocos.
     */
    public String getMensaje(){
        return MENSAJES[currentPos];
    }
    
}
