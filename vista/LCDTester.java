
package vista;
import controlador.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class LCDTester {
	
	//Cadena para terminar el proceso 
    static final String CADENA_FINAL = "0,0";
    

    public static void main(String[] args) {

        //Establece los segmentos de cada numero
        List<String> listaComando = new ArrayList<>();
        //Entrada por consola de un posible espacioDig
        String comandoSinValidar;
        //Espacio entre numeros
        int espacioDig;
        
        try {

        		Scanner lector = new Scanner(System.in);
                
                System.out.print("Espacio entre Digitos (0 a 5): ");
                comandoSinValidar = lector.next();

                // Valida si es un numero aceptado para ser espacioDig
                espacioDig =  ControladorLCD.validaEspacioEntreDigitos(comandoSinValidar);
                
                //Entrada de posibles datos para cololocados en estilo LCD
                entradaDeDatos(listaComando,lector);
            
                ControladorLCD controladorLCD = new ControladorLCD();

            Iterator<String> iterator = listaComando.iterator();
            
            controladorLCD.comenzarProseso(iterator,espacioDig);
        } catch (Exception ex) {
        	
        	 System.out.println("Error: "+ex.getMessage());
        }

    }
    public static void imprimirMatriz(String[][]matrizImpr,int totalFilas,int totalColum) {
    	
 // Imprime matriz
    for (int i = 0; i < totalFilas; i++) {
    	
        for (int j = 0; j < totalColum; j++) {
        	
            System.out.print(matrizImpr[i][j]);
        }
        System.out.println();
    }
    }
    
    static List<String> entradaDeDatos(List<String> listaComando,Scanner lector) {
    	
    	String comando;
    
    do{
        System.out.print("Entrada: ");
        comando = lector.next();
        if(!comando.equalsIgnoreCase(CADENA_FINAL)) {
        	
            listaComando.add(comando);
        }
    }while (!comando.equalsIgnoreCase(CADENA_FINAL)); 
    
   return listaComando;
}
}