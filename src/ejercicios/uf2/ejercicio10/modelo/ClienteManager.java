package ejercicios.uf2.ejercicio10.modelo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteManager {
    
    private final static String URL_BASE = "http://10.0.2.4:8080/api/clientes"; 
    
    public static ClienteApi[] getAll(){
        ClienteApi[] todos = null;
        HttpClient cliente = getCliente();
        
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(URL_BASE))
                .build();
        
        try {
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode()==200){
                String json = response.body();
                ObjectMapper om = new ObjectMapper();
                todos = om.readValue(json, ClienteApi[].class);
            }else{
                Logger.getLogger(ClienteManager.class.getName()).log(Level.SEVERE, null, "Servidor responde: "+response.statusCode());
            }
        
        } catch (IOException ex) {
            Logger.getLogger(ClienteManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todos;
    } 

    private static HttpClient getCliente() {
        HttpClient cliente = HttpClient
                .newBuilder()
                .build();
        return cliente;
    }
    
    public static boolean updateCliente(ClienteApi ca) {
        boolean actualizado = false;
        HttpClient cliente = getCliente();
        
        if(ca.getCodCliente()==null){
            Logger.getLogger(ClienteManager.class.getName()).log(Level.SEVERE, null, "codCliente no puede ser null.");
            return false;
        }
        
        //Obtenemos el JSON de ca
        ObjectMapper om = new ObjectMapper();
        try {
            String json = om.writeValueAsString(ca);
            HttpRequest request = HttpRequest
                .newBuilder(URI.create(URL_BASE+"/"+ca.getCodCliente()))
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();
            
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            
            if(response.statusCode()==201){
                actualizado = true;
            }else{
                Logger.getLogger(ClienteManager.class.getName()).log(Level.SEVERE, null, "HTTP-"+response.statusCode());
                Logger.getLogger(ClienteManager.class.getName()).log(Level.SEVERE, null, response.body());
            }
                
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ClienteManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return actualizado;
    }
    
}
