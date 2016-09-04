package clases;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Juani
 */
public class Cliente implements Serializable {
    private String nombre;
    private long telefono;
    private String mail;
    private ArrayList<Auto> autos = new ArrayList();

    public Cliente(String nombre, long telefono, String mail) {
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
    }
//devuelve el nombr del cliente
    public String getNombre() {
        return nombre;
    }
//devuelve el mail del cliente
    public String getMail() {
        return mail;
    }
//devuelve el telefono del cliente
    public long getTelefono() {
        return telefono;
    }
//añade un auto a un array de autos  
    public void addAuto(Auto auto){
        autos.add(auto);
        Clientes.save();
        Clientes.load();
    }
//devuelve el array de autos
    public ArrayList<Auto> getAutos(){
        return autos;
    }
//elimina un auto del array de autos
    public void removeAuto(Auto autoR){
        autos.remove(autoR);
        Clientes.save();
        Clientes.load();
    }
    
    public String toString(){
        String nombreN= nombre;
        while(nombreN.length()<35) nombreN += " ";
        return nombreN+telefono;
    }
}
