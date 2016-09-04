package clases;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author user2
 */
public abstract class Clientes implements Serializable{
    private static ArrayList<Cliente> clientes = new ArrayList();
    private static final String archivo = "DataBase.TdB";
    private static FileInputStream fis = null;
    private static ObjectInputStream ois = null;
    private static FileOutputStream fos = null;
    private static ObjectOutputStream oos = null;
//devuelve el array de clientes
    public static ArrayList<Cliente> getClientes (){
        return clientes;
    }
//eliminar un cliente del array de clientes
    public static void removeCliente (Cliente cliente) {
        clientes.remove(cliente);
        save();
        load();
    }
//añade un cliente al array de clientes
    public static void addCliente (Cliente cliente){
        clientes.add(cliente);
        save();
        load();
    }
//Guarda los objetos
    public static String save() {
        String ret = "Carga exitosa";
        boolean flag = true;
        String fileTmp = "tmpFile.db";
        //Se carga el array en un archivo temporal
        try {
            fos = new FileOutputStream(fileTmp);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            

        } catch (FileNotFoundException ex) {
            flag = false;
            System.out.println("No se encuentra el archivo");
        } catch (IOException ex) {
            flag = false;
            System.out.println("Error al guardar el archivo");
            return ret;
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                    oos = null;
                }
                if (fos != null) {
                    fos.close();
                    fos = null;
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo");
            }
        }
        //Si todo salió bien, se borra el archivo db actual 
        //y lo reemplaza por tmpFile.db
        File fdel = new File(archivo);
        File ftmp = new File(fileTmp);
        if (fdel.exists()) {
            if (fdel.delete()) {
                ftmp.renameTo(new File(archivo));
            }
        } else {
            ftmp.renameTo(new File(archivo));
        }


        return ret;

    }
//carga los objetos
    public static void load() {
        
        System.out.println("Intentando levantar la lista");
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);

            while (true) {
                clientes = (ArrayList<Cliente>) ois.readObject();                
            }

        }catch (EOFException e1) {
            //END OF FILE!
            System.out.println("Sale");
        } catch (Exception e2) {
            System.out.println("Error!!!" + e2);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                    ois = null;
                }
                if (fis != null) {
                    fis.close();
                    fis = null;
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo");
            }
        }
        
    }
//busca un cliente a partir de un nombre insertado
    public static ArrayList<Cliente> search (String nombre){
        ArrayList<Cliente> ret = new ArrayList<>();
        for (int i=0; clientes.size()>i; i++){
            if (clientes.get(i).getNombre().contains(nombre)) 
                ret.add(clientes.get(i));
            
        }
        return ret;
    }
//devuelve (dia/mes/año)
   public static String getFecha(){
       Date fecha = new Date();
       return fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+ (fecha.getYear()+1900);
   }
   
//devuelve una imagen cargada a partir de una ruta insertada
    public static Image getIconImage(String image) {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(image));
        return retValue;
        
    }
}
