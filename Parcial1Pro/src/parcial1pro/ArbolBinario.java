package parcial1pro;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* * @author Luis Fernando Paxel
 */
public class ArbolBinario {

    ArrayList<Integer> guardarInOrden = new ArrayList<>();
    ArrayList<Integer> guardarPreOrden = new ArrayList<>();
    ArrayList<Integer> guardarPostOrden = new ArrayList<>();

    NodoArbol raiz;
    public ArbolBinario() {
        raiz = null;
    }

    //Metodo para insertar un nodo en el arbol
    public void agregarNodo(int d) {
        NodoArbol nuevo = new NodoArbol(d);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while (true) {
                padre = auxiliar;
                if (d < auxiliar.dato) {
                    auxiliar = auxiliar.hijoIzquierdo;
                    if (auxiliar == null) {
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.hijoDerecho;
                    if (auxiliar == null) {
                        padre.hijoDerecho = nuevo;
                        return;
                    }

                }
            }
        }
    }

    public boolean Vacio() {
        return raiz == null;

    }

    //Metodo para recorrer en INORDEN
    public void inOrden(NodoArbol r) {

        if (r != null) {
            inOrden(r.hijoIzquierdo);
            //    System.out.print(r.dato + ",");
            guardarInOrden.add(r.dato);
            inOrden(r.hijoDerecho);
        }

    }

    public void txtInOrden() {
        try {
            String filePath = "In_Ordern.txt";
            try (FileWriter fww = new FileWriter(filePath, true)) {

                String lineToAppend = String.valueOf(guardarInOrden);

                fww.write(lineToAppend);
         fww.close();
       
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    //Metodo para recorrer en INORDEN
    public void preOrden(NodoArbol r2) {

        if (r2 != null) {

            // System.out.print(r2.dato + ",");
            guardarPreOrden.add(r2.dato);
            preOrden(r2.hijoIzquierdo);
            preOrden(r2.hijoDerecho);
        }
    }

    public void txtPre_Orden() {
        try {
            String filePath = "Pre_Orden.txt";
            try (FileWriter fz = new FileWriter(filePath, true)) {

                String lineToAppend = String.valueOf(guardarPreOrden);

                fz.write(lineToAppend);
                fz.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    //Metodo para recorrer en INORDEN
    public void postOrden(NodoArbol r3) {
        if (r3 != null) {
            postOrden(r3.hijoIzquierdo);// Hijo izquierdo
            postOrden(r3.hijoDerecho); // Hijo derecho
            guardarPostOrden.add(r3.dato);
            // System.out.print(r3.dato + ",");// Raiz
        }
    }

    public void txtPost_Orden() {
        try {
            String filePath = "Post_Orden.txt";
            try (FileWriter fc = new FileWriter(filePath, true)) {

                String lineToAppend = String.valueOf(guardarPostOrden);

                fc.write(lineToAppend);
           fc.close();
       
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
