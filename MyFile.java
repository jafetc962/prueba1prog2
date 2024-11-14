
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class MyFile {
    
    //hecho en clase
    private File mifile=null;
    
    void setFile(String direccion){
        mifile=new File(direccion);
    }
    
    void info() {
        if (mifile.exists()) {
            System.out.println("\nNombre: " + mifile.getName());
            System.out.println("Path: " + mifile.getPath());
            System.out.println("Absoluta: " + mifile.getAbsoluteFile());
            System.out.println("Bytes: " + mifile.length());
            System.out.println("Modificado en: " + new Date(mifile.lastModified()));
            System.out.println("Padre: " + mifile.getAbsoluteFile().getParentFile().getName());
            if (mifile.isFile()) {
                System.out.println("ES FILE");
            } else if (mifile.isDirectory()) {
                System.out.println("ES FOLDER");
            }
            System.out.println("-+-+-+-+-+-+-+-+-");
        }else{
            System.out.println("No existe!");
        }
    }
    boolean crearFile()throws IOException{
        return mifile.createNewFile();
    }
    boolean crearFolder(){
     return mifile.mkdirs();
    }
    
    void borrar() {
        if (antidoto(mifile)) {
            System.out.println("Borrado!");
        } else {
            System.out.println("No se pudo borrar!");
        }
    }

    private boolean antidoto(File mf) {
        if (mf.isDirectory()) {
            for (File child : mf.listFiles()) {
                antidoto(child);
            }
        }
        return mf.delete();
    }
    void dir() {
        if (mifile.isDirectory()) {
            System.out.println("Directorio de: " + mifile.getAbsolutePath());
            System.out.println("");

            // Contadores
            int cfiles = 0, cdirs = 0, tbytes = 0;

            // Recorrido
            for (File child : mifile.listFiles()) {
                if (!child.isHidden()) {
                    // Última Modificación
                    Date ultimo = new Date(child.lastModified());
                    System.out.print(ultimo + "\t");

                    // Si es File o Folder
                    if (child.isDirectory()) {
                        cdirs++;
                        System.out.print("<DIR>\t\t");
                    } else {
                        cfiles++;
                        tbytes += child.length();
                        System.out.print("\t" + child.length() + "\t");
                    }

                    // Mostrar los objetos
                    System.out.println(child.getName());
                }
            }

            System.out.println(cfiles + " archivos \t" + tbytes + " bytes");
            System.out.println(cdirs + " dirs\n");
        }
    }
    
    private void tree(File dir,String tab){
        if(dir.isDirectory()){
            System.out.println(tab+dir.getName());
            for(File child:dir.listFiles()){
                if(!child.isHidden()){
                    tree(child,tab+"--");
                }
            }
        }
    }
    
    void tree(){
        tree(mifile,"-");
    }
    
    //prueba 1 parcial dos funciones pedidas
    //---------------------------------------------------------------------
    void escribirTexto(String texto, boolean append) throws IOException {
        try (FileWriter fw = new FileWriter(mifile, append);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(texto);
            bw.newLine();
        }
    }
    
    
    void leerTextoFileReader() throws IOException {
        try (FileReader fr = new FileReader(mifile);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
    
    void leerTextoScanner() throws IOException {
        try (Scanner scanner = new Scanner(mifile)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
    //---------------------------------------------------------------
}
