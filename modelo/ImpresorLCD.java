
package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ImpresorLCD  {

    // Puntos fijos
    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;
    private String[][] matrizImpr;
    
    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y";

    // TODO code application logic here
    //String entrada = JOptionPane.showInputDialog("Digite el numero");
    private int size;

    // Calcula el numero de filasDig
    private int filasDig;
    private int columDig;
    private int totalFilas;
    private int totalColum;

    public ImpresorLCD() {
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }
    /**
     * devuelve el total de filas 
     * @return 
     */
    public int getFilas(){
    	
    	return this.totalFilas;
    	
    }
    /**
     * devuelve el total de columnas
     * @return
     */
    public int getColumnas(){
    	
    	return this.totalColum;
    	
    }

    /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param matriz Matriz Impresion
     * @param punto Punto Pivote
     * @param posFija Posicion Fija
     * @param size Tamaño Segmento
     * @param caracter Caracter Segmento
     */    
    private void adicionarLinea(String[][] matriz, int[] punto, String posFija,
            int size, String caracter) {

        if (posFija.equalsIgnoreCase(POSICION_X))  {
            for (int y = 1; y <= size; y++) {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        } 
        else {
            for (int i = 1; i <= size; i++)  {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }

    /**
     *
     * Metodo encargado de adicionae un segmento a la matriz de Impresion
     *
     * @param segmento Segmento a adicionar
     */  
    private void adicionarSegmento(int segmento) {

        switch (segmento) {
            case 1:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 2:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 3:
                adicionarLinea(this.matrizImpr, this.pf5, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 4:
                adicionarLinea(this.matrizImpr, this.pf4, POSICION_Y,
                        this.size, CARACTER_VERTICAL);
                break;
            case 5:
                adicionarLinea(this.matrizImpr, this.pf1, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 6:
                adicionarLinea(this.matrizImpr, this.pf2, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            case 7:
                adicionarLinea(this.matrizImpr, this.pf3, POSICION_X,
                        this.size, CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }
    /**
     *
     * Metodo encargado de definir los segmentos que componen un digito y
     * a partir de los segmentos adicionar la representacion del digito a la matriz
     *
     * @param numero Digito
     */
    private void adicionarDigito(int numero) {

        // Establece los segmentos de cada numero
        List<Integer> segList = new ArrayList<>();

        switch (numero) {
            case 1:
                segList.add(3);
                segList.add(4);
                break;
            case 2:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                break;
            case 3:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 4:
                segList.add(1);
                segList.add(6);
                segList.add(3);
                segList.add(4);
                break;
            case 5:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 6:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                segList.add(4);
                break;
            case 7:
                segList.add(5);
                segList.add(3);
                segList.add(4);
                break;
            case 8:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 9:
                segList.add(1);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 0:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(7);
                break;
            default:
                break;
        }

        Iterator<Integer> iterator = segList.iterator();

        while (iterator.hasNext()) {
            adicionarSegmento(iterator.next());
        }
    }
    /**
    *
    * Metodo encargado de Organizar la matriz de impresion en su tamaño 
    * escogido para ser impreso
    * 
    * @param size Tamaño Segmento Digitos
    * @param numeroImp Numero a Imprimir
    * @param espacio Espacio Entre digitos
    */    
   public String[][] organizarNumeroParaImprimir(int size, String numeroImp, int espacio) 
   {
       int pivotX = 0;
       char[] digitos;

       this.size = size;

       // Calcula el numero de filas cada digito
       this.filasDig = (2 * this.size) + 3;

       // Calcula el numero de columna de cada digito
       this.columDig = this.size + 2;

       // Calcula el total de filas de la matriz en la que se almacenaran los digitos
       this.totalFilas = this.filasDig;

       // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
       this.totalColum = (this.columDig * numeroImp.length())
               + (espacio * numeroImp.length());

       // crea matriz para almacenar los numero a imprimir
       this.matrizImpr = new String[this.totalFilas][this.totalColum];

       // crea el arreglo de digitos
       digitos = numeroImp.toCharArray();

       // Inicializa matriz
       for (int i = 0; i < this.totalFilas; i++) {
           for (int j = 0; j < this.totalColum; j++) {
               this.matrizImpr[i][j] = " ";
           }
       }

       for (char digito : digitos) {
           
           //Valida que el caracter sea un digito
           if( ! Character.isDigit(digito))
           {
               throw new IllegalArgumentException("Caracter " + digito
                   + " no es un digito");
           }

           int numero = Integer.parseInt(String.valueOf(digito));

           //Calcula puntos fijos
           this.pf1[0] = 0;
           this.pf1[1] = 0 + pivotX;

           this.pf2[0] = (this.filasDig / 2);
           this.pf2[1] = 0 + pivotX;

           this.pf3[0] = (this.filasDig - 1);
           this.pf3[1] = 0 + pivotX;

           this.pf4[0] = (this.columDig - 1);
           this.pf4[1] = (this.filasDig / 2) + pivotX;

           this.pf5[0] = 0;
           this.pf5[1] = (this.columDig - 1) + pivotX;

           pivotX = pivotX + this.columDig + espacio;

           adicionarDigito(numero);
       }

       return this.matrizImpr;
   }
    

}