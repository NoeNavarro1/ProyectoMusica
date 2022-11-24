/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.proyectomusica_v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Noena
 */
public class ProyectoMusica_V2 {

    public static void leerArchivo(String name) {
        File archivo = null; //apunta a un archivo fisico de dd
        FileReader fr = null; //para leer el archivo 
        BufferedReader bufer = null;
        try {
            //creamos un apuntador al archivo físico
            archivo = new File("C:\\Users\\Noena\\" + name);
            //abrimos el archivo para lectura
            fr = new FileReader(archivo);
            //configurar bufer para hacer la lectura
            bufer = new BufferedReader(fr);

            //Lectura del contenido del archivo 
            String linea;
            //mientras haya informacion en el archivo
            while ((linea = bufer.readLine()) != null) {
                System.out.println("Linea de archivo " + linea);
            }

        } catch (Exception e) {
            System.out.println("No se encuentra el archivo");
            e.printStackTrace();
        } finally {
            //esta cláusula se ejecuta siempre
            //Se cierra el archivo
            try {
                //si se logro abrir el archivo,debemos cerrarlo
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar el archivo");
                e2.printStackTrace();
            }
        }

    }

    public static void escribirArchivo(String name) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        BufferedReader bufer2 = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;
        try {
            archivo = new FileWriter("C:\\Users\\Noena\\" + name + ".txt");
            pw = new PrintWriter(archivo);
            do {
                System.out.println("Escribe informacion a guardar en el archivo: ");
                entrada = bufer2.readLine();
                //Agrega lo leido en teclado al archivo en disco
                pw.println(entrada);

                System.out.println("Escribe s para continuar, n para parar");
                entrada = bufer2.readLine();
                respuesta = entrada.charAt(0);
            } while (respuesta != 'n');

        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + name);
            e.printStackTrace();
        } finally {
            try {
                //Cerrar el archivo i es que se pudo abrir para escritura
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo" + name);
                e2.printStackTrace();
            }
        }
    }

    public static void editarArchivo(String name) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        BufferedReader bufer2 = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;
        try {
            archivo = new FileWriter("C:\\Users\\Noena\\" + name + ".txt");
            pw = new PrintWriter(archivo);
            do {
                System.out.println("Edita información del archivo: ");
                entrada = bufer2.readLine();
                //Agrega lo leido en teclado al archivo en disco
                pw.println(entrada);

                System.out.println("Escribe s para continuar, n para parar");
                entrada = bufer2.readLine();
                respuesta = entrada.charAt(0);
            } while (respuesta != 'n');

        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + name);
            e.printStackTrace();
        } finally {
            try {
                //Cerrar el archivo i es que se pudo abrir para escritura
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar archivo" + name);
                e2.printStackTrace();
            }
        }
    }
    
    public static void eliminarArchivo(String name){
        File archivo = null;
        if(archivo.delete()){
            System.out.println("Archivo eliminado con exito");
        }else{
            System.out.println("Error al eliminar archivo");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buferTeclado = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        String fileName;
        int opcion;

        System.out.println("Programa que manupula archivos de texto");
        System.out.println("--------------------------------------------");
        System.out.println("¿Que quieres hacer?");
        System.out.println("1 -Leer un archivo de texto existente");
        System.out.println("2 -Crear un archivo de texto");
        System.out.println("3 -Editar un archivo de texto");
        System.out.println("4 -Eliminar archivo de texto!!!!!");
        entrada = buferTeclado.readLine();
        opcion = Integer.parseInt(entrada);
        System.out.println("Escribe el nombre del archivo");
        entrada = buferTeclado.readLine();
        fileName = entrada;
        switch (opcion) {
            case 1: {
                //Lectura de un archivo de texto
                System.out.println("Lectura de un archivo existente");
                System.out.println("Contenido del archivo: ");
                leerArchivo(entrada);
            }
            break;
            case 2: {
                System.out.println("Creacion de un archivo de texto");
                escribirArchivo(fileName);
            }
            break;
            case 3: {
                System.out.println("Funcion todavia no disponible");
            }
            break;
            case 4: {
                System.out.println("Archivo eliminado correctamente");
                eliminarArchivo(entrada);
            }
            break;
            default:
                System.out.println("Opcion no valida");
        }

    }

}
