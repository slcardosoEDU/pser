package ejercicios.ejercicio2;

/**
 * Hilo que incrementa un contador.
 * @author Samuel Loureiro Cardoso
 */
class Hilo extends Thread{
    private Contador cont;
    /**
     * Número de veces que se incrementa el contador.
     */
    public static int NUM_INCREMENTOS;
    
    /**
     * Crea un hilo que incrementará el contador c cuando se ejecute.
     * @param c Contador que incrementará el hilo.
     */
    public Hilo(Contador c){
        cont = c;
    }
    
    /**
     * Incrementa el contador un número determinado de veces.
     */
    public void run(){
        for(int i=0; i<NUM_INCREMENTOS;i++){
            cont.incrementa();
        }
    }
}
