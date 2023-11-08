package ejercicios.ejercicio5;

/**
 *
 * @author samuel
 */
public class Principal {
    public final static int MAX_EMPLEADOS = 10;
    public static void main(String[] args) {
        Oficina o = new Oficina();
        for(int i = 1; i<=MAX_EMPLEADOS;i++){
            Empleado e = new Empleado("Emp "+i, o);
            e.start();
        }
        Empleado jefe = new Empleado("Jefe", o, true);
        jefe.start();
    }

}
