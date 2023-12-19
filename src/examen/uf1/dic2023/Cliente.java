package examen.uf1.dic2023;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cliente que va a comprar entradas a un punto de venta.
 * @author Samuel
 */
public class Cliente extends Thread {
    public final static int MAX_CLIENTES = 20;
    public final static int MAX_COMPRA = 2;
    public final static int NUM_ENTRADAS = 10;
    
    private PuntoVenta pv;
    private int id;    

    /**
     * Crea un cliente con un identificador.
     *
     * @param id Numero identificador del cliente.
     * @param pv Punto de venta donde el cliente intenta comprar entradas.
     */
    public Cliente(int id, PuntoVenta pv) {
        super("Cliente_" + id);
        this.id = id;
        this.pv = pv;
    }

    @Override
    public void run() {
        Random r = new Random();
        //Calculamos las entradas que quiere.
        int quiero = r.nextInt(NUM_ENTRADAS-1) + 1;
        System.out.println(getName() + "-quiere-" + quiero);
        
        //Entradas que tiene el cliente actualmente.
        int tengo = 0;
        //El cliente va al punto de venta a comprar entradas mientras no consiga
        //todas las entradas que quiere.
        while (quiero > tengo) {
            try {
                //Tiempo que tarda en ir a la tienda.
                Thread.sleep(new Random().nextInt(1000) + 1000);
                //El cliente intenta comprar el maximo permitido salvo que necesite menos,
                //en cuyo caso comprara las que necesite.
                int intentoComprar = quiero - tengo < MAX_COMPRA ? quiero - tengo : MAX_COMPRA;
                int compra = pv.comprar(intentoComprar);
                //Si el cliente vuelve de la tienda sin entradas es porque
                //se han agotado (y el proveedor no va a volver).
                //En ese caso salimos del bucle.
                if (compra == 0) {
                    break;
                }
                tengo += compra;
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
