package parcial1pro;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * @author Luis Fernando Paxel
 */
public class Parcial1Pro {
    
    public static void main(String[] args) {
        int opcion = 0, elemento;
        String nombre;
        ArbolBinario arb = new ArbolBinario();
        ArrayList<Integer> guar = new ArrayList<>();
        Random Num = new Random();
        int desde = -10000, hasta = 10000;
        for (int i = 0; i < 1000000; i++) {
            elemento = Num.nextInt(hasta - desde + 1) + desde;
            //            System.out.println("[" + i + "]= " + elemento);
            guar.add(elemento);
            arb.agregarNodo(elemento);
        }
        
        try {
            String filePath = "Prueba2.txt";
            try (FileWriter fw = new FileWriter(filePath, true)) {
                String lineToAppend = String.valueOf(guar);
                
                fw.write(lineToAppend);
                fw.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Angregar Nodo \n" + "2. Recorrer inOrden\n" + "3. Recorrer preOrden\n" + "4. Rrecorrer postOrden \n" + "5.Salir \n" + "Elige una opcion", "Arboles Binarios", JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1:
                        //   nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del nodo", "Agregando nodo", JOptionPane.QUESTION_MESSAGE);

                        //       arb.agregarNodo(elemento);
                        break;
                    case 2:
                        if (!arb.Vacio()) {
                            System.out.println("\n Recorrido InOrden:");
                            
                            arb.inOrden(arb.raiz);
                            arb.txtInOrden();
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Error", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                        break;
                    
                    case 3:
                        if (!arb.Vacio()) {
                            System.out.println("\n Recorrido PreOrden:");
                          arb.preOrden(arb.raiz);
                            arb.txtPre_Orden();
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Error", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                        
                        break;
                    
                    case 4:
                        if (!arb.Vacio()) {
                            System.out.println("\n Recorrido PostOrden:");
                            
                            arb.postOrden(arb.raiz);
                            arb.txtPost_Orden();
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Error", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Aplicacion Finalizada", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Incorrecta", "nmms", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
            }
            
        } while (opcion != 5);
        
    }
    
}
