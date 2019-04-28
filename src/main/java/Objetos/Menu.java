package Objetos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    ArrayList<Zapatilla> sap;
    Archivos ar=new Archivos();

    /**
     * Menu principal de la aplicación.
     */
    public void inicio() {
        String ruta="";
        boolean estado = true;
        while (estado) {
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Sacar iformacion de Archivo JSON");
            System.out.println("2. Meter la informacion en un archivo JSON");
            System.out.println("3. Ver la información");
            System.out.println("4. Agregar informacion");
            System.out.println("5. Salir");
            int opcion = recibirValidar();
            switch (opcion) {
                case 1:
                        System.out.println("Ingrese la ruta");
                        ruta=recibirPalabra();
                        ar.JSONArrayAobjetos(ar.leerArchivo(ruta));
                        sap=ar.getArregloS();                       
                    break;
                case 2: System.out.println("Ingrese la ruta");
                        ruta=recibirPalabra();
                        ar.crearArchivoJ(ruta, sap);
                    break;
                case 3: System.out.println("Lista de zapatillas");
                        for(int i=0;i<sap.size();i++){
                            System.out.println("Marca: "+sap.get(i).getMarca());
                            System.out.println("Modelo: "+sap.get(i).getModelo());
                            System.out.println("Color: "+sap.get(i).getColor());
                            System.out.println("");
                        }
                    break;
                case 4: System.out.println("Ingrese la marca de la zapatilla");
                        String marca=recibirPalabra();
                        System.out.println("Ingrese el modelo");
                        String modelo=recibirPalabra();
                        System.out.println("Ingrese el color");
                        String color=recibirPalabra();
                        Zapatilla n=new Zapatilla(marca,modelo,color);
                        sap.add(n);
                    break;
                case 5:
                    estado = false;
                    break;

            }
        }
    }
    
    public static String recibirPalabra() {
        String num = " ";
        boolean estado = true;

        while (estado) {

            try {
                Scanner sc = new Scanner(System.in);

                num = sc.nextLine();
                estado = false;

            } catch (InputMismatchException e) {
                System.out.println("El caracter ingresado no es una palabra, intentelo nuevamente.");
                estado = true;
            }

        }
        return num;
    }
    public static int recibirValidar() {
    int num = 0;
    boolean estado = true;

    while (estado) {

        try {
            System.out.println("Ingrese un numero");
            Scanner sc = new Scanner(System.in);

            num = sc.nextInt();
            estado = false;

        } catch (InputMismatchException e) {
            System.out.println("El caracter ingresado no es numerico o se encuentra fuera del rango establecido, intentelo nuevamente.");
            estado = true;
        }

    }
    return num;
}
}
