
package ejercicios.uf2.ejercicio10.modelo;


public class ClienteApi {
    
    private Integer codCliente;
    private String nombre;
    private Integer codProvincia;
    private Integer vip;

    public ClienteApi() {
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(Integer codProvincia) {
        this.codProvincia = codProvincia;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "ClienteApi{" + "codCliente=" + codCliente + ", nombre=" + nombre + ", codProvincia=" + codProvincia + ", vip=" + vip + '}';
    }
    
    
    
}
