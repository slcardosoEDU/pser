package ejercicios.ejercicio7;

/**
 *
 * @author Samuel
 */
public class Main {
    final static int NUM_EMPLEADOS = 20;
    
    public static void main(String[] args) throws InterruptedException {
        Bote bote  = new Bote();
        Empleado[] emps = new Empleado[NUM_EMPLEADOS];
        for(int i = 0; i < NUM_EMPLEADOS; i++){
            emps[i] = new Empleado("E"+(i+1), bote);
            emps[i].start();
        }
        
        for(Empleado e : emps){
            e.join();
        }
        Resultado r = Resultado.getResultadoAleatorio();
        System.out.println(bote);
        System.out.println("RESULTADO "+r);
        System.out.println(bote.getGanadores(r));
        
        

           

    }

}
