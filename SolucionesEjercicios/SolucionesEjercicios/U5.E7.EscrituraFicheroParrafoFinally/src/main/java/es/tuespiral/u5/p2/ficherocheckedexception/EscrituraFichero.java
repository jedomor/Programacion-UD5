package es.tuespiral.u5.p2.ficherocheckedexception;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class EscrituraFichero {

    private String nombreFichero = "";
    // La clase File representa un fichero y su ruta completa en el sistema
    // de ficheros del sistema operativo.
    private File fichero;
    // La clase FileWriter permite crear objetos que saben escribir caracteres
    // a un fichero.
    private FileWriter fw;
    // La clase PrintWriter permite escribir líneas completas a un fichero de
    // forma cómoda para el programador. Ejemplo: println()
    private PrintWriter pw;
    private boolean abierto = false;

    public EscrituraFichero(String nombre) {
        if (nombre != null) {
            nombreFichero = nombre;
        }
    }

    public void abrir() throws IOException {
        fichero = new File(nombreFichero);
        fw = new FileWriter(fichero);
        pw = new PrintWriter(fw);
        abierto = true;
    }

    public void cerrar() throws IOException {
        if (abierto) {
            pw.close();
            fw.close();
            abierto = false;
        } else {
            throw new IllegalStateException("El fichero no está abierto");
        }
    }

    public void escribeTexto(String linea) throws IOException {
        if (abierto) {
            if (linea != null) {
                pw.println(linea);
            }
        } else {
            throw new IllegalStateException("El fichero no está abierto");
        }
    }

    public void escribeTexto(List<String> parrafo) throws IOException {
        if (abierto) {
            Iterator<String> iter = parrafo.iterator();

            while (iter.hasNext()) {
                String linea = iter.next();
                pw.println(linea);
            }
        } else {
            throw new IllegalStateException("El fichero no está abierto");
        }
    }

    public void abreEscribeCierra(List<String> parrafo) {
        try {
            abrir();

            Iterator<String> iter = parrafo.iterator();

            while (iter.hasNext()) {
                String linea = iter.next();
                pw.println(linea);
            }
        } catch (IOException ex) {
            System.out.println("Se produjo un error al abrir o escribir en el fichero");
        } finally {
            try {
                cerrar();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fichero");
            }
        }
    }
}
