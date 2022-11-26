/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.proyectomusica_v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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

    //metodo que ayuda a poder leer archivos con extension .txt
    public static void leerArchivo(String name) {
        File archivo = null; //apunta a un archivo fisico de dd
        FileReader fr = null; //para leer el archivo 
        BufferedReader bufer = null;
        try {
            //creamos un apuntador al archivo físico
            archivo = new File("C:\\Users\\Noena\\Artistas.txt");
            //abrimos el archivo para lectura
            fr = new FileReader(archivo);
            //configurar bufer para hacer la lectura
            bufer = new BufferedReader(fr);

            //Lectura del contenido del archivo 
            String linea;
            //mientras haya informacion en el archivo
            while ((linea = bufer.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (Exception e) {
            System.out.println("No se encuentra el archivo: " + name);
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
                System.out.println("Error al cerrar el archivo: " + name);
                e2.printStackTrace();
            }
        }

    }

    //Ayuda a la creacion de un Nuevo artista
    public static void escribirArchivo(String name) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        BufferedReader bufer2 = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char respuesta;
        try {
            archivo = new FileWriter("C:\\Users\\Noena\\Artistas.txt");
            pw = new PrintWriter(archivo);
            do {
                System.out.println("Creacion del artista: ");
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

    public static void borrarDatos(String name) {
        try {
            String path = "C:\\Users\\Noena\\Artistas.txt";
            File archivo = new File(path);

            File archivoTemp = new File(archivo + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            PrintWriter pw = new PrintWriter(new FileWriter(archivoTemp));

            String linea = null;

            //Copia el contenido del archivo, menos la linea que se indica que se va a borrar
            while ((linea = br.readLine()) != null) {
                /*String.trim() método que borra los carácteres vacíos iniciales y finales de la cadena
          Ejemplo: " Hola!" -> "Hola"
                 */
                if (!linea.trim().equals(name)) {

                    pw.println(linea);
                    //flush() cuando no queremos cerrar el archivo, pero sí vacear el bufer
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Validación de eliminar el archivo orginal
            if (!archivo.delete()) {
                System.out.println("No se pudo eliminar el archivo" + name);
                return;
            }

            //Renombrar el archivo temporal como el archivo original
            if (!archivoTemp.renameTo(archivo)) {
                System.out.println("No se pudo renombrar el archivo" + name);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
