package ejercicios.uf2.ejercicio7;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class Webscraper {

    public final static String URL = "https://www.scrapethissite.com/pages/simple/";
    
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
       //Peticion http
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URL))
                .build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8")));
        
        List<Pais> paises = new ArrayList<>();
        //Dividimos el HTML en vaarios strings "partiendo" por el div de cada pais.
        String[] parser = response.body().split("<div class=\"col-md-4 country\">");
        for(int i = 1; i<parser.length; i++){
            int inicio, fin;
            //Pais
            inicio = parser[i].indexOf("</i>")+5;
            fin = parser[i].indexOf("</h3>");
            String pais = parser[i].substring(inicio, fin).trim();
            //Capital
            inicio = parser[i].indexOf("<span class=\"country-capital\">")+30;
            fin = parser[i].indexOf("</span>");
            String capital = parser[i].substring(inicio, fin);
            //Poblacion
            inicio = parser[i].indexOf("<span class=\"country-population\">")+33;
            fin = parser[i].indexOf("</span>",inicio);
            Integer poblacion = Integer.valueOf(parser[i].substring(inicio, fin));
            //Area
            inicio = parser[i].indexOf("<span class=\"country-area\">")+27;
            fin = parser[i].indexOf("</span>",inicio);
            Double area = Double.valueOf(parser[i].substring(inicio, fin));
            paises.add(new Pais(pais, capital, area, poblacion));
            //System.out.println(capital+": "+poblacion);
        }
        //Mostrar lista de paises
        for(Pais p: paises){
            System.out.println(p);
        }
    }
}
