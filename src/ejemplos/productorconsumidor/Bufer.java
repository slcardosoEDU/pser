package ejemplos.productorconsumidor;

/**
 *
 * @author samuel
 */
public class Bufer {
    
    private Integer dato;
    public Bufer(){
        dato = null;
    }
    
    public synchronized void escribir(Integer dato) throws InterruptedException{
        if(this.dato!=null){
           wait();
        }
         this.dato = dato;
         notify();
        
    }
    
    public synchronized Integer leer() throws InterruptedException{
        while(dato==null){
            wait();
        }
        Integer aux = dato;
        dato = null;
        notify();
        return aux;
    }
    
    public boolean vacio(){
        return dato == null;
    }

}
