package ejemplos.productorconsumidor;

/**
 *
 * @author samuel
 */
public class Main {

    public static void main(String[] args) {
        Bufer b = new Bufer();
        Productor p = new Productor(b);
        Consumidor c = new Consumidor(b);
        p.start();
        c.start();
    }

}
