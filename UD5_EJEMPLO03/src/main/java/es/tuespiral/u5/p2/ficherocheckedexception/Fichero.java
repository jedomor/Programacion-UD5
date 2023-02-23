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

    public void abrir() throws FileNotFoundException {
        fichero = new File(nombreFichero);
        fr = new FileReader(fichero);
        br = new BufferedReader(fr);
        abierto = true;
    }

    public void cerrar() throws IOException {
        if (abierto) {
            br.close();
            fr.close();
            abierto = false;
        } else {
            throw new IllegalStateException("El fichero no está abierto");
        }
    }

    public void imprimeContenido() throws IOException {
        if (abierto) {
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } else {
            throw new IllegalStateException("El fichero no está abierto");
        }
    }
    
}
