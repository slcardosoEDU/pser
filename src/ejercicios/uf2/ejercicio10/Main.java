/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.uf2.ejercicio10;

import ejercicios.uf2.ejercicio10.modelo.ClienteApi;
import ejercicios.uf2.ejercicio10.modelo.ClienteManager;
import java.util.Arrays;


public class Main {
     public static void main(String[] args) {
        
        ClienteApi[] clientes = ClienteManager.getAll();
        System.out.println(Arrays.toString(clientes));
        ClienteApi actualizar = clientes[0];
        actualizar.setNombre("DOROTEO");
        if(ClienteManager.updateCliente(actualizar)){
            System.out.println("Actualizado");
        }else{
            System.out.println("ALGO HA FALLADO!");
                 
        }
        
        clientes = ClienteManager.getAll();
        System.out.println(Arrays.toString(clientes));
    }
}
