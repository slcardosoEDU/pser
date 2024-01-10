package ejercicios.uf2.ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servidor de echo que solo puede atender a un cliente. <br>
 * El servidor finaliza su ejecución cuando recibe del cliente un mensaje con la
 * palabra 'fin'.
 *
 * @author Samuel
 */
public class Servidor {

    private static boolean encendido = true;
    private static ServerSocket server;
    public static List<HiloCliente> CLIENTES_CONECTADOS;
    public static HashMap<String,Integer> HISTORICO_CONEXIONES;

    public static void main(String[] args) {

        try {
            CLIENTES_CONECTADOS = new ArrayList();
            HISTORICO_CONEXIONES = new HashMap();
            
            server = new ServerSocket(Conexion.PUERTO());
            System.out.println("Servidor escuchando en " + server.getLocalSocketAddress());
            
            //Recibimos clientes mientras el servidor este "encendido".
            while (encendido) {
                Socket cliente = server.accept();
                //Abrimos un hilo para procesar cada cliente
                HiloCliente hiloSocket = new HiloCliente(cliente);
                hiloSocket.start();
            }

        } catch (IOException ex) {
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Apagando...");

    }

    public static void shutdown() {
        
        encendido = false;
            try {
                server.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        synchronized (CLIENTES_CONECTADOS) {
            
            for(HiloCliente c: CLIENTES_CONECTADOS){
                c.shutdown();
            }
            
            CLIENTES_CONECTADOS.clear();
        }
        
        synchronized (HISTORICO_CONEXIONES) {
            HISTORICO_CONEXIONES.clear();
        }

    }

    public static String getTime() {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss");
        return formater.format(LocalDateTime.now());
    }

}
