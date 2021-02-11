/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Permutaciones (Forma recursiva)
//- Importa posición
//- Sin repetición
//- Requisito: R >= N
package decimal.a.binario;

/**
 *
 * @author developer
 */
public class Permutacion {
     public static void main(String[] args) {
        String[] elementos = "a,b,c,".split(",");
        int n = 4;                  //Tipos para escoger
        int r = elementos.length;   //Elementos elegidos
        Perm2(elementos, "", n, r);
    }
     private static void Perm2(String[] elem, String act, int n, int r) {
        if (n == 0) {
            System.out.println(act);
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + ", ", n - 1, r);
                }
            }
        }
    }
}
