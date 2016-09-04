package clases;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Juani
 */
public class Auto implements Serializable {
    private String marca;
    private String modelo;
    private String patente;
    private ArrayList<Arreglo> arreglos = new ArrayList();

    public Auto(String marca, String modelo, String patente) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
    }
//devuelve la marca del auto
    public String getMarca() {
        return marca;
    }
//devuelve el modelo del auto
    public String getModelo() {
        return modelo;
    }
//devuelve la patente del auto
    public String getPatente() {
        return patente;
    }
//devuelve el array de arreglos
    public ArrayList<Arreglo> getArreglos() {
        return arreglos;
    }
//añade un arreglo al array de arreglos
    public void addArreglos(Arreglo arregloR) {
        arreglos.add(arregloR);
        Clientes.save();
        Clientes.load();
    }
//elimina un arreglo del array de arreglos
    public void removeArreglo (Arreglo arregloR) {
        arreglos.remove(arregloR);
        Clientes.save();
        Clientes.load();
    }

    public String toString(){
        String marcaN = marca ;
        String modeloN = modelo;
        while (marcaN.length()<15) marcaN += " ";
        while (modeloN.length()<19) modeloN += " ";
        return (marcaN + modeloN + patente);
    }
        
}
