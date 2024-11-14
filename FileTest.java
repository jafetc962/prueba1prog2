
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class FileTest {
     public static void main(String[] args) throws IOException {
        Scanner lea = new Scanner(System.in);
        int menu = 0;
        //-----------
        int menuE=0;
        int menul=0;
        //----------
        MyFile mf = new MyFile();

        do {
            System.out.println("1- Set Archivo/Folder");
            System.out.println("2- Ver información");
            System.out.println("3- Crear Archivo");
            System.out.println("4- Crear Folder");
            System.out.println("5- Borrar");
            System.out.println("6- DIR");
            System.out.println("7- TREE");
            //funciones por prueba
            //------------------------------------------------------
            System.out.println("8- Escribir Texto");
            System.out.println("9- Leer Texto");
            //-------------------------------------------------------
            System.out.println("10- Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                menu = lea.nextInt();
                lea.nextLine();  
                switch (menu) {
                    case 1:
                        System.out.print("Ingrese la direccion: ");
                        String direccion = lea.nextLine();
                        mf.setFile(direccion);
                        break;
                    case 2:
                        mf.info();
                        break;
                    case 3:
                        if (mf.crearFile()) {
                            System.out.println("Se creó un nuevo archivo.");
                        } else {
                            System.out.println("No se pudo crear el archivo.");
                        }
                        break;
                    case 4:
                        if (mf.crearFolder()) {
                            System.out.println("Se creó un nuevo folder.");
                        } else {
                            System.out.println("No se pudo crear el folder.");
                        }
                        break;
                    case 5:
                        mf.borrar();
                        break;
                    case 6:
                        mf.dir();
                        break;
                    case 7:
                        mf.tree();
                        break;
                        //----------------------------------------------------------
                    case 8: 
                        System.out.println("1- Sobreescribir Texto");
                        System.out.println("2- Añadir Texto");
                        System.out.print("Seleccione una opcion: ");
                        menuE = lea.nextInt();

                        switch (menuE) {
                            case 1:
                                System.out.print("Ingrese el texto a escribir: ");
                                String textoSobreescribir = lea.next();
                                mf.escribirTexto(textoSobreescribir, false);
                                System.out.println("Texto sobrescrito en el archivo.");
                                break;
                            case 2:
                                System.out.print("Ingrese el texto a añadir: ");
                                String textoAñadir = lea.next();
                                mf.escribirTexto(textoAñadir, true);
                                System.out.println("Texto añadido al archivo.");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;

                        }

                        break;
                    case 9: 
                        System.out.println("1- Leer Texto (Con FileReader)");
                        System.out.println("2- Leer Texto (Con Scanner)");
                        System.out.print("Seleccione una opcion: ");
                        menul = lea.nextInt();
                        switch (menul) {

                            case 1:
                                System.out.println("Contenido del archivo (con FileReader):");
                                mf.leerTextoFileReader();
                                break;
                            case 2:
                                System.out.println("Contenido del archivo (con Scanner):");
                                mf.leerTextoScanner();
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                break;

                        }
                        break;      
                    case 10: 
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                //-----------------------------------------------------------
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese una opción válida.");
                lea.next();
            } catch(NullPointerException e){
                System.out.println("Por favor seleccionar primero la opcion 1!");
            }catch (IOException e) {
                System.out.println("Error al manipular el archivo.");
            }
        } while (menu != 10);
    }
}
