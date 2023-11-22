package ejercicios.ejercicio8;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author usuarioa
 */
public class Hwwc {

    public final static int NUM_METEORITOS = 10;
    private static Hwwc singleton = null;
    private ArrayList<Meteorito> meteoritos;

    private Hwwc() {
        meteoritos = new ArrayList();
        for (int i = 1; i <= NUM_METEORITOS; i++) {
            meteoritos.add(new Meteorito(i));
        }

    }

    public static Hwwc getInstancia() {
        if (singleton == null) {
            singleton = new Hwwc();
        }
        return singleton;
    }

    public boolean hayMeteoritos() {
        return !meteoritos.isEmpty();
    }

    public void boom() {
        Random r = new Random();
        synchronized (meteoritos) {
            if(meteoritos.isEmpty())
                return;
            int pos = r.nextInt(meteoritos.size());
            Meteorito m = meteoritos.get(pos);
            //isTaladrado?
            //TODO Repostar nave A
            meteoritos.remove(pos);
        }
        
    }

    public void taladrar() {
        Meteorito m;
        Random r = new Random();
        if(meteoritos.isEmpty())
                return;
        synchronized (meteoritos) {
            int pos = r.nextInt(meteoritos.size());
            m = meteoritos.get(pos);
        }
        m.taladrar();
    }

    public Meteorito getMeteorito() {
        synchronized (meteoritos) {
            Random r = new Random();
            return meteoritos.get(r.nextInt(meteoritos.size()));
        }
    }

    public void eliminarMeteorito(int pos) {
        synchronized (meteoritos) {
            meteoritos.remove(pos);
        }
    }
    
    public void eliminarMeteorito(Meteorito m) {
        synchronized (meteoritos) {
            meteoritos.remove(m);
        }
    }

}
