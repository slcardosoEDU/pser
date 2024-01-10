package ejercicios.uf2.ejercicio1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket servidor = new Socket(Conexion.SERVIDOR(), Conexion.PUERTO());
            DataInputStream in = new DataInputStream(servidor.getInputStream());
            DataOutputStream out = new DataOutputStream(servidor.getOutputStream());
            String respuesta, mensaje;
            do {
                System.out.print("Mensaje > ");
                mensaje = sc.nextLine();
                //Enviar al servidor
                out.writeUTF(mensaje);
                System.out.println("Enviado");
                //Esperamos la respuesta
                respuesta = in.readUTF();
                System.out.println("Servidor responde: " + respuesta);
            } while (!"fin".equalsIgnoreCase(respuesta));

            servidor.close();

            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conexión cerrada");
    }

    
}
