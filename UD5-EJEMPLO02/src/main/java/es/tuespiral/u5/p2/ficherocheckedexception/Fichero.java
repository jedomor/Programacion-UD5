package es.tuespiral.u5.p2.ficherocheckedexception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fichero {

    private String nombreFichero = "";
    // La clase File representa un fichero y su ruta completa en el sistema
    // de ficheros del sistema operativo.
    private File fichero;
    // La clase FileReader permite crear objetos que saben leer un array de 
    // caracteres de un fichero.
    private FileReader fr;
    // La clase BufferedReader permite crear un objeto que toma un FileReader
    // como entrada y es capaz de ofrecer operaciones de lectura más cómodas
    // para el programador. Ejemplo: readLine()
    private BufferedReader br;
    private boolean abierto = false;

    public Fichero(String nombre) {
        if (nombre != null) {
            nombreFichero = nombre;
        }
    }

    public void abrir() {
        try {
            fichero = new File(nombreFichero);
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            abierto = true;
        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + nombreFichero + " no se pudo abrir porque no se encuentra");
        }
    }

    public void cerrar() {
        if (abierto) {
            try {
                br.close();
                fr.close();
                abierto = false;
            } catch (IOException e) {
                System.out.println("El fichero no se pudo cerrar");
            }
        } else {
            throw new IllegalStateException("El fichero no está abierto");
        }
    }

    public void imprimeContenido() {
        if (abierto) {
            try {
                String linea = br.readLine();
                while (linea != null) {
                    System.out.println(linea);
                    linea = br.readLine();
                }
            } catch (IOException e) {
                System.out.println("No se puede mostrar el contenido. Se ha producido un error al leer del archivo");
            }
        } else {
            throw new IllegalStateException("El fichero no está abierto");
        }
    }
}
