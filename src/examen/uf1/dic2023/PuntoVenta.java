package examen.uf1.dic2023;

import java.util.Random; 

/**
 *
 * @author Samuel
 */
public class PuntoVenta {
    /**
     * Cantidad de entradas que puede almacenar el punto de venta.
     */
    public final static int MAX_ENTRADAS = 10;
    private int stockEntradas;
    private boolean noHayRepuestos;
    
    /**
     * En un principio el punto de venta no tiene entradas.
     */
    public PuntoVenta(){
        stockEntradas = 0;
        noHayRepuestos = false;
    }
    
    /**
     * Un proveedor puede utilizar este método para ofrecer una cantidad
     * de entradas (oferta) al punto de venta.
     * El punto de venta tomará de la oferta todas las entradas que pueda 
     * sin sobrepasar su capacidad.
     * @param oferta Cantidad de entradas que el proveedor ofrece al punto de venta.
     * @return las entradas que se han agregado al punto de venta.
     * @throws java.lang.InterruptedException
     * @see #MAX_ENTRADAS
     */
    public synchronized int reponer(int oferta) throws InterruptedException{
        int necesarias = 0;
        //Si el punto de venta no tiene capacidad para mas entradas el proveedor (productor) espera.
        //Evitamos la espera activa hasta que el punto de venta tenga sitio para las entradas.
        if(stockEntradas==MAX_ENTRADAS){
            wait();
        }
        //Calculamos cuantas entradas de la oferta son necesarias
        if(oferta+stockEntradas<=MAX_ENTRADAS){            
            necesarias = oferta;
        }else{
            necesarias = MAX_ENTRADAS - stockEntradas;
        }
        
        System.out.println("proveedor-repone-"+necesarias);
        stockEntradas += necesarias;
        //Despertamos a un cliente que espera para comprar entradas (consumidor).
        notify();
        return necesarias;
    }
    
    /**
     * Un cliente puede utilizar este método para intentar comprar una cantidad
     * de entradas en el punto de venta.
     * @param entradas cantidad de entradas que el cliente desea comprar.
     * @return cantidad de entradas compradas. Si devuelve 0 es que las entradas
     * se han agotado (tanto en el punto de venta como en el proveedor).
     */
    public synchronized int comprar(int entradas) throws InterruptedException{
        
        int compradas = entradas;
        //Mientras el punto de venta no tiene entradas  suficientes evitamos la espera activa.
        while(stockEntradas<entradas){
            //En caso de que el proveedor no vaya a volver
            //se compran todas las entradas posibles.
            if(noHayRepuestos){
                //Si el punto de venta no tiene ninguna entrada no hay nada que 
                //comprar, terminamos sin comprar entradas (0 entradas).
                if(stockEntradas==0)
                    return 0;
                //Se comprarn las entradas que quedan.
                compradas = stockEntradas;
            }
            wait();
        }

        stockEntradas -= compradas;
        System.out.println(Thread.currentThread().getName()+"-compra-"+compradas);
        //Avisamos al proveedor que puede estar esperando o al siguiente cliente.
        notify();
        return compradas;
    }
    
    /**
     * Este metodo lo utiliza el proveedor para indicar que no va a volver a 
     * reponer entradas.
     */
    public synchronized void setNoHayRepuestos(){
        notifyAll();
        this.noHayRepuestos = true;
    }

    /**
     * Devuelve la cantidad de entradas que tiene el punto de venta en este
     * momento.
     * @return entradas disponibles en el punto de venta.
     */
    public int getStockEntradas() {
        return stockEntradas;
    }    
    
}
