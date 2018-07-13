/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author CLIENTE
 */
public class Pi {

    /**
     * @param args the command line arguments
     */
    
    public static int cols;
    public static int rows;
    public static int max_value;
    
    public static void main(String[] args) throws FileNotFoundException {

        processaImagem pi = new processaImagem("barbara.ascii.pgm");
        
    }
  
}
