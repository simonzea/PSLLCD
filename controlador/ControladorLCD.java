/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista.*;
import modelo.*;
import java.util.Iterator;

public class ControladorLCD {
	
	
	public static int validaSize(String size) {
		int  tam;
		if(isNumeric(size)){
            tam = Integer.parseInt(size);
            
            // se valida que el size este entre 1 y 10
            if(tam <1 || tam >10){
            	throw new IllegalArgumentException("El parametro size ["+tam
                        + "] debe estar entre 1 y 10");
            }
        }
        else{
        	
        	throw new IllegalArgumentException("El parametro size  [" + size
                    + "] no es un numero");
        }
		return tam;
	}
	
	
	
	
	 /*
	  * 
	  * para la especificacion de esto recordar los throws
	  */
	public static int validaEspacioEntreDigitos(String comando) {
	 if (isNumeric(comando)) {
        int espacioDig = Integer.parseInt(comando);
         
         // se valida que el espaciado este entre 0 y 5
         if(espacioDig <0 || espacioDig >5){     	 
        	
        	 throw new IllegalArgumentException("El espacio entre "
                     + "digitos debe estar entre 0 y 5");            
         }else{
        	 return espacioDig;
         }    
     } 
     else {
    	 throw new IllegalArgumentException("Cadena " + comando
                 + " no es un entero"); 
     }
	}
	
	
	
	
	/**
    *
    * Metodo encargado de validar si una cadena es numerica
    *
    * @param cadena Cadena
    */  
   public static boolean isNumeric(String cadena) {
       try {
           Integer.parseInt(cadena);
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }

   /**
    *  
    * @param comando
    * @param espacioDig
    * 
    */
  public  void procesar(String comando, int espacioDig)  {
      
      String[] parametros;
      String[][]matrizImpr;
      
      int tam;
      //Se valida que el comando contega el caracter ,
      if (!comando.contains(",")){
          throw new IllegalArgumentException("Cadena " + comando
                  + " no contiene caracter ,");
      }
      
      //Se hace el split de la cadena
      parametros = comando.split(",");
      
    //Valida la cantidad de parametros
      validarCantidadDeParametros(parametros,comando);
      
      //Valida que el parametro size sea un numerico
      tam =validaSize(parametros[0]);

      
      ImpresorLCD impresorLCD = new ImpresorLCD();
      // Realiza la creacion de la matriz para imprimir
      matrizImpr=impresorLCD.organizarNumeroParaImprimir(tam, parametros[1],espacioDig);
      
      // Realiza la impresion de la matriz
      LCDTester.imprimirMatriz( matrizImpr,impresorLCD.getFilas(),impresorLCD.getColumnas());

  }
  
  /**
   * Valida que la entrada tenga el numero de parametros requeridos
   * @param parametros
   * @param comando
   */
 public static void validarCantidadDeParametros(String[] parametros,String comando){
	 
	//Valida la cantidad de parametros
     if(parametros.length>2){
        throw new IllegalArgumentException("La cadena " + comando
                 + " contiene mas caracter ,"); 
     }
     
     //Valida la cantidad de parametros
     if(parametros.length<2){
        throw new IllegalArgumentException("La cadena " + comando
                 + " no contiene los parametros requeridos"); 
     }
 }
  /**
   * Proccesa cada entrada
   * @param iterator
   * @param espacioDig
   */
  public void comenzarProseso(Iterator<String> iterator, int espacioDig){
  while (iterator.hasNext()) {
      try  {
          procesar(iterator.next(), espacioDig);
      } catch (Exception ex) {
      	System.out.println("Error: "+ex.getMessage());
      }
  }
}
  
}


