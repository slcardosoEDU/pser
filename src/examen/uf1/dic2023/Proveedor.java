package examen.uf1.dic2023;

import java.util.Random;

/**
 *
 * @author Samuel
 */
public class Proveedor extends Thread{
    private int numProductos;
    public final static int MAX_PRODUCTOS = 100;
    public final static int OFERTA_PRODUCTOS = 10;
    private PuntoVenta ptv;
    public Proveedor(PuntoVenta ptv) {
        numProductos = MAX_PRODUCTOS;
        this.ptv = ptv;
    }
    
    public void run(){
        System.out.println("Proveedor empieza a vender.");
        while(numProductos > 0){
            //Gestionar interrupciones
            if(isInterrupted()){
                System.out.println("Proveedor-sobran-"+numProductos);
                return;
            }
            
            try {
                Thread.sleep(new Random().nextInt(800)+200);
                int productosDispo = OFERTA_PRODUCTOS;
                if(numProductos < OFERTA_PRODUCTOS){
                    productosDispo = numProductos;
                }
                numProductos -= ptv.reponer(productosDispo);
            } catch (InterruptedException ex) {
                interrupt();
            }
            
        }
        ptv.setNoHayRepuestos();
    }
    
    
}
