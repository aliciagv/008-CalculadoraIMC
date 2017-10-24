/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cice.principal;

import com.cice.excepciones.NotCalculateException;
import com.cice.logica.Logica;
import com.cice.persona.Persona;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alicia
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("*************** CALCULADORA IMC *****************");
        System.out.println("=================================================");
        System.out.println("");
        Persona persona = new Persona();
        System.out.print("Introduce el nombre: ");
        persona.setNombre(sc.next());
        System.out.print("Introduce tus apellidos: ");
        persona.setApellidos(sc.next());
        
        System.out.print("Introduce tu edad: ");
        if (sc.hasNextInt()) {
            persona.setEdad(sc.nextInt());
        } else {
            System.out.println("La edad introducida es incorrecta");
            sc.next();
        }
        
        System.out.print("Introduce tu peso en kg: ");
        if (sc.hasNextDouble()){
            persona.setPeso(sc.nextDouble());
        } else {
            System.out.println("El peso introducido es incorrecto");
            sc.next();
        }
        
        System.out.print("Introduce tu altura en metros: ");
        if (sc.hasNextDouble()){
            persona.setAltura(sc.nextDouble());
        } else {
            System.out.println("La altura introducida no es correcta");
            sc.next();
        }
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("¿Qué quieres hacer " + persona.getNombre() + "?");
        int opcion=0;
        do {
            
        System.out.println("1. Calcular tu IMC");
        System.out.println("0. Salir");
        try {
        opcion=sc.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Adios");
                    break;
                case 1:
        {
            try {
                Logica.calcularIMC(persona);
            } catch (NotCalculateException ex) {
                System.out.println(ex.getMessage());
                opcion=0;
            }
        }
                    break;
                default:
                    System.out.println("La opcion es incorrecta");
                    opcion=1;
            }
        } catch(InputMismatchException ime){
            System.out.println("La opcion es incorrecta");
            sc.next();
        }
        
        } while (opcion!=0);
    }
    
}
