/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controlador.*;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author User
 */
public class testControladorLCD {
    
    public testControladorLCD() {
    }

    
     @Test
     public void testvalidaEspacioEntreDigitos() {
         int resultadoActual=ControladorLCD.validaEspacioEntreDigitos("3");
         int resultadoEsperado=3;
         assertEquals(resultadoActual, resultadoEsperado, "Error test validar Espacio entre digitos");
     }
     public void testvalidaSize() {
         ControladorLCD controladorLCD= new ControladorLCD();
         int resultadoActual=controladorLCD.validaSize("9");
         int resultadoEsperado=9;
         assertEquals(resultadoActual, resultadoEsperado, "Error test validar size");
     }
     public void testisNumerictrue() {
         ControladorLCD controladorLCD= new ControladorLCD();
         boolean resultadoActual=controladorLCD.isNumeric("99");
         boolean resultadoEsperado=true;
         assertEquals(resultadoActual, resultadoEsperado, "Error test validar isNumeric");
     }

     public void testisNumericfalse() {
         ControladorLCD controladorLCD= new ControladorLCD();
         boolean resultadoActual=controladorLCD.isNumeric("9q");
         boolean resultadoEsperado=false;
         assertEquals(resultadoActual, resultadoEsperado, "Error test validar isNumeric");
     }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
