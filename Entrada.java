package clases;

import java.io.Serializable;

/**
 *
 * @author user2
 */
public class Entrada implements Serializable {
    private String fecha;
    private String info;
    private double coste;

    public Entrada(String info, double coste) {
        this.info = info;
        this.coste = coste;
        this.fecha = Clientes.getFecha();
    }
//devuleve la fecha
    public String getFecha() {
        return fecha;
    }
//devuelve la informacion
    public String getInfo() {
        return info;
    }
//devuelve el coste
    public double getCoste() {
        return coste;
    }
 
    public String toString(){
        String fechaN= fecha;
        while (fechaN.length()<20) fechaN += " ";
        return fechaN + "$ " + coste;
    }
    
    
    
}
