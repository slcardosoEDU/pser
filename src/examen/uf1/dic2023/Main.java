package examen.uf1.dic2023;

/**
 * Hilo principal. <br>
 * Aquí se crean e inicia los hilos cliente y proveedor junto con el punto de
 * venta.
 * @author Samuel
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        PuntoVenta ptv = new PuntoVenta();
        //Lanzamos el proveedor.
        Proveedor prov = new Proveedor(ptv);      
        prov.start();
        //Lanzamos los clientes.
        Cliente[] clientes = new Cliente[Cliente.MAX_CLIENTES];
        for(int i=0; i<Cliente.MAX_CLIENTES; i++){
            Cliente c = new Cliente(i,ptv);
            c.start();
            clientes[i] = c;
        }
        
        for(Cliente c: clientes){
            c.join();
        }
        //Cuando acaben todos los clientes, paramos el proveedor si sigue corriendo.
        if(prov.isAlive()){
            prov.interrupt();
        }
        //Hay que esperar a que termine el proveedor.
        prov.join();
        //Mostramos las entradas que sobran en el punto de venta.
        System.out.println("puntov-sobran-"+ptv.getStockEntradas());
    }
}
