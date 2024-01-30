package ejercicios.uf2.ejercicio7;

/**
 *
 * @author Samuel
 */
public class Pais {

    private String nombre;
    private String capital;
    private Double area;
    private Integer poblacion;

    public Pais(String nombre, String capital, Double area, Integer poblacion) {
        this.nombre = nombre;
        this.capital = capital.equals("None")?null:capital;
        this.area = area;
        this.poblacion = poblacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return this.nombre + "\n\tCapital: " + this.capital + "\n\tÁrea: " + area+"\n\tPoblación: "+this.poblacion;
    }

}
