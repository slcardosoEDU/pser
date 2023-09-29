package ejemplos.crearhilos;

/**
 * Se instancian y lanzan hilos de 3 formas diferentes desde el hilo principal
 * (main).
 * <br>
 * Las 3 formas propuestas son:
 * <ol>
 * <li>Crear hilos extendiendo de la clase Thread.</li>
 * <li>Crear hilos utilizando una clase que implemente Runnable.</li>
 * <li>Crear hilos utilizando una clase anónima que implemente Runnable</li>
 * </ol>
 *
 * @author Samuel Loureiro Cardoso
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
        Thread h1 = new Thread(new HiloRunnable("H1", 3000));
        Thread h2 = new Thread(new HiloRunnable("H2", 500));

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
