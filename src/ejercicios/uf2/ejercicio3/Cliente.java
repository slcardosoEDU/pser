package ejercicios.uf2.ejercicio3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cliente de echo. <br>
 * Utiliza sockets para enviar un mensaje al servidor.<br>
 * El programa finalizará cuando el servidor responda 'fin'.
 *
 * @author Samuel
 */
public class Cliente {

    public static boolean interrumpido;

    public static void main(String[] args) throws InterruptedException {
        interrumpido = false;
        StringContainer respuesta = new StringContainer();
        try {

            Socket servidor = new Socket(Conexion.SERVIDOR(), Conexion.PUERTO());
            DataInputStream in = new DataInputStream(servidor.getInputStream());
            DataOutputStream out = new DataOutputStream(servidor.getOutputStream());
            //Creamos 2 hilos:
            //Hilo1: para recibir mensajes del servidor.
            Thread receptor = new Thread(() -> hiloReceptor(in, respuesta));
            receptor.start();
            //Hilo2: para comunicarnos con el usuario y enviar mensajes al servidor.
            Thread emisor = new Thread(() -> hiloEmisor(out, respuesta));
            emisor.start();
            //Cuando termine el hilo receptor (el servidor envia un FIN_CONN_CLIENTE
            receptor.join();
            //Interrumpimos el emisor y cerramos su Scanner por si está esperando por una entrada de usuario.
            emisor.interrupt();
            //Cierra el scanner pero no termina la interrupción [falla]
            interrumpido = true;
            //Cerramos el ServerSocket
            servidor.close();
           
            System.exit(0);

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("Conexión cerrada");
        
    }

    public static void hiloReceptor(DataInputStream in,  StringContainer respuesta) {
        while (true) {
            synchronized (respuesta) {
                if(!respuesta.isEmpty()){
                    try {
                        respuesta.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {                    
                    respuesta.set(in.readUTF());
                    if (Conexion.FIN_CONN_CLIENTE.equalsIgnoreCase(respuesta.get())) {
                        respuesta.set("");
                        break;
                    }
                    respuesta.notify();

                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void hiloEmisor(DataOutputStream out, StringContainer respuesta) {
        Thread hilo = Thread.currentThread();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //El emisor funcionara mientras no lo interrumpan desde fuera.
        while (!hilo.isInterrupted()) {
            
            synchronized (respuesta) {
                if (respuesta.isEmpty()) {
                    System.out.println("Esperando respuesta del servidor...");
                    try {
                        respuesta.wait();                        
                    } catch (InterruptedException ex) {
                        hilo.interrupt();
                    }
                }
                System.out.println("> "+respuesta);
                respuesta.set("");
                respuesta.notify();
            }
            //Interaccion con el usuario. Va fuera del bloque sincronizado para no bloquear los
            //mensajes entrantes del servidor.
            try{
               //Comprobar el estado del buffer por si el usuario ha escrito algo.
               while (!br.ready()  && !interrumpido) {
                    Thread.sleep(200);
                }
               String mensaje = br.readLine(); 
               out.writeUTF(mensaje);               
            } catch (Exception ex) {
 
                hilo.interrupt();
            }           
            
        }

        //Cerramos el outputStream
        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Esta clase se utiliza para poder utilizar Strings
     * como candados. 
     */
    static class StringContainer{
        private String contenido;
        public StringContainer(){
            contenido = "";
        }
        
        public void set(String contenido){
            this.contenido = contenido;
        }
        
        public String get(){
            return contenido;
        }
        public boolean isEmpty(){
            return contenido.isEmpty();
        }
        
        public String toString(){
            return contenido;
        }
        
    }

}
