package ejemplos.crearhilos;

/**
 *
 * @author Samuel
 */
public class Principal {
    public static void main(String[] args) {
        //Probando hilo con Thread
//        Thread h1 = new Hilo("H1");
//        Hilo h2 = new Hilo("H2");
//        Hilo h3 = new Hilo("H3");
//        h1.start();
//        h2.start();
//        h3.start();

    //Probando hilo con Runnable
    Thread h1 = new Thread(new HiloRunnable("H1",3000));
    Thread h2 = new Thread(new HiloRunnable("H2",500));
    
    h1.start();
    h2.start();
    //Probando hilo con clase anonima
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Hago una cosa que solo hago aquí.");
        }
    });
    t.start();
    }
    
}
