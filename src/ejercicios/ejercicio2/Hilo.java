package ejercicios.ejercicio2;

/**
 *
 * @author Samuel
 */
class Hilo extends Thread{
    private Contador cont;
    public static int NUM_INCREMENTOS;
    
    public Hilo(Contador c){
        cont = c;
    }
    
    public void run(){
        for(int i=0; i<NUM_INCREMENTOS;i++){
            cont.incrementa();
        }
    }
}
