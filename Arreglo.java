package clases;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Juani
 */
public class Arreglo implements Serializable {
    private String fecha;
    private double km;
    private double coste;
    private String estado;
    private ArrayList<Entrada> entradas = new ArrayList();

    public Arreglo(double km) {
        this.km = km;
        this.estado= "Incompleto";
        this.fecha = Clientes.getFecha();
    }
//crea una nueva entrada en el array de entradas    
    public void addEntrada(Entrada entradaR) {
        if (estado.equals("Incompleto")){
            entradas.add(entradaR);
            Clientes.save();
            Clientes.load();
        }
    }
//elimina una entrada en el array de entradas
    public void removeEntrada(Entrada entradaR) {
        if (estado.equals("Incompleto")){
            entradas.remove(entradaR);
            Clientes.save();
            Clientes.load();
        }
    }
//devuelve la fecha
    public String getFecha() {
        return fecha;
    }
//devuelve los kilometros
    public double getKm() {
        return km;
    }
//devuelve el coste total, este se calcula sumando todos los costes de las entredas
    public double getCostet() {
        coste=0;
        for (Entrada entrada : entradas) {
           coste += entrada.getCoste();
        }
        return coste;
    }
//devuelve el estado 
    public String getEstado() {
        return estado;
    }
//cambia el estado de incompleto a terminado
    public void changeEstado() {
        this.estado = "Terminado";
    }
//devuelve el array de entradas
    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public String toString(){
        String fechaN= fecha;
        String estadoN = estado;
        while (fechaN.length()<15) fechaN += " ";
        while (estadoN.length()<15) estadoN += " ";
        return fechaN + estadoN +"$ " +getCostet();
    }
    
}
