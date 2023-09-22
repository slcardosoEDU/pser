package problema.recreo;


/**
 * Reprenta el Comecocos que puede indicar mensajes.
 * @author Samuel Loureiro Cardoso
 */
public class Comecocos extends Thread{
    /**
     * Posibles mensajes. Cada posición del array representa una cara del comecocos.
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
    
    public Comecocos(){
        super();
        currentPos = 0;
        stop = false;
    }
    
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
    
    public void detener(){
        stop = true;
    }
    public String getMensaje(){
        return MENSAJES[currentPos];
    }
    
}
