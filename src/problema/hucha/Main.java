package problema.hucha;


/**
 *
 * @author Samuel
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Hucha h = new Hucha();
        Hijo[] hijos = new Hijo[Hijo.NUM_HIJOS];
        Padre padres = new Padre(h);
        padres.start();
        for(int i = 0; i<hijos.length; i++){
            hijos[i] = new Hijo("Hijo "+(i+1),h);
            hijos[i].start();
        }
        
        for (Hijo hijo : hijos) {
            hijo.join();
        }
        
        padres.interrupt();
        padres.join();
        System.out.println("--------------\ndinero restante");
        System.out.println(h);
        
    }
}
