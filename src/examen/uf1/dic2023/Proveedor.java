package examen.uf1.dic2023;

import java.util.Random;

/**
 *
 * @author Samuel
 */
public class Proveedor extends Thread{
    private int numEntradas;
    public final static int TOTAL_ENTRADAS = 100;
    
    private PuntoVenta ptv;
    public Proveedor(PuntoVenta ptv) {
        numEntradas = TOTAL_ENTRADAS;
        this.ptv = ptv;
    }
    
    public void run(){
        System.out.println("Proveedor empieza a vender.");
        while(numEntradas > 0){
            //Gestionar interrupciones
            if(isInterrupted()){
                System.out.println("Proveedor-sobran-"+numEntradas);
                return;
            }
            
            try {
                Thread.sleep(new Random().nextInt(800)+200);
                int productosDispo = PuntoVenta.MAX_ENTRADAS;
                if(numEntradas <  PuntoVenta.MAX_ENTRADAS){
                    productosDispo = numEntradas;
                }
                numEntradas -= ptv.reponer(productosDispo);
            } catch (InterruptedException ex) {
                interrupt();
            }
            
        }
        ptv.setNoHayRepuestos();
    }
    
    
}
