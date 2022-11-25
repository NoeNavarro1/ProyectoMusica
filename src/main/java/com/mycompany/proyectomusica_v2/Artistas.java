/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectomusica_v2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Noena
 */
public class Artistas {
    
    public static void Artista(String name) {
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
    
    
    
}
