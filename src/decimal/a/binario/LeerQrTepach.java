/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decimal.a.binario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Linux
 */
public class LeerQrTepach {

    public String ObtieneFolBinario(String Cadeniux, int inicio, int fin) {
        char myCharcero = (char) 14;//14
        char myCharuno = (char) 15;//15
        //Reemplaza los caracteres no visibles por unos y ceros dejando un código binario + la pagina
        Cadeniux = Cadeniux.replace(myCharcero, '0');
        Cadeniux = Cadeniux.replace(myCharuno, '1');
        //Aqui toma los primeros binarios
        Cadeniux = Cadeniux.substring(inicio, fin);
        //Valida que el numero sea binario si es binario se queda el valor en cero de lo contrario es uno y la var se va en nada
        return Cadeniux;
    }
    
    

    public int decimal(String bin) {
        int num = Integer.parseInt(bin, 2);
        return num;
    }

    public String binario(int decimal) {
        String data = Integer.toBinaryString(decimal);
        return data;
    }

    public String binarioUnicode(String binario, String url, String tipo) {
        char myCharcero = (char) 48;
        char myCharuno = (char) 49;
        binario = binario.replace(myCharcero, '\u000E');//u000E --u001B
        binario = binario.replace(myCharuno, '\u000F');//u000F  --u001C
        tipo = tipo.replace(myCharcero, '\u000E');//u000E
        tipo = tipo.replace(myCharuno, '\u000F');//u000F
        return binario + url + tipo;
    }

    public String cerosIzq(String binario, int cant_ceros) {
        String ceros_izq = binario;
        while (ceros_izq.length() < cant_ceros) {
            ceros_izq = "0" + ceros_izq;
        }
        return ceros_izq;
    }

    public void generarFolios(int fol_ini, int fol_fin, int tip, String url, String ruta) {
        ArrayList<String> lista = new ArrayList();
        String tipo = cerosIzq(binario(tip), 4);
        for (int i = fol_ini; i <= fol_fin; i++) {
            String folio = cerosIzq(binario(i), 30);
            lista.add(binarioUnicode(folio, url, tipo));
        }
        imprimeLista(lista, ruta);
    }

    private void imprimeLista(ArrayList<String> lista, Object ruta) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ruta.toString());
            pw = new PrintWriter(fichero);
            for (int i = 0; i < lista.size(); i++) {
                pw.println(lista.get(i));
            }
            fichero.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.fillInStackTrace(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            JOptionPane.showMessageDialog(null, "Se guardando en: \n" + ruta.toString(), "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String NumeroBinario(String cad) {
        long Suma = 0;
        String cadena="";
        if (cad.length() > 0) {
            for (int i = 0; i <= cad.length() - 1; i++) {
                if (String.valueOf(cad.codePointAt(i)).equals("31")) {
                    //System.out.println("Suma: "+Suma);
                    Suma += Potencia(2, i);
                   cadena=cadena+"#";
                                 }else{
                cadena=cadena+"@";
                }
            }
        }
        System.out.println(cadena);
        return String.valueOf(Suma);
    }
   

    private long Potencia(int x, int y) {
        long potencia = 1;
        for (int i = 1; i <= y; i++) {
           // System.out.println("Potencia: "+potencia);
            potencia *= (long) x;
            
        }
        return potencia;
    }

    public static void main(String[] args) {
        LeerQrTepach leerQrTepach = new LeerQrTepach();
        System.out.println(leerQrTepach.ObtieneFolBinario("", 0, 10));
        System.out.println(leerQrTepach.ObtieneFolBinario("", 10, 36));
    }

}
