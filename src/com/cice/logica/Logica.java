/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cice.logica;

import com.cice.excepciones.NotCalculateException;
import com.cice.persona.Persona;

/**
 *
 * @author Alicia
 */
public class Logica {
    private static final String IMCMIN_16="Desnutrido severo";
    private static final String IMC16_18="Desnutrido";
    private static final String IMC18_25="Normal";
    private static final String IMC25_30="Sobrepeso";
    private static final String IMCMAX_30="Obesidad";

    public static void calcularIMC(Persona p) throws NotCalculateException { // no utiliza 
        // IMC= peso (kg) /altura al cuadrado en metros
        // menor 16 bajo peso severo
        //  menor que 18,5 y mayor o igual 16
        // menor que 25 normal y mayor o igual de 18,5
        // entre 25 y 30 sobrepeso 
        // mayor 30 obesidad
        if (p != null && p.getAltura() != 0 && p.getPeso() != 0) {
            double imc= p.getPeso()/Math.pow(p.getAltura(),2);
            
            if (imc<16){
                System.out.println("IMC: " + imc + " " + IMCMIN_16);
            } else if (imc <18.5){
                 System.out.println("IMC: " + imc + " " + IMC16_18);
            } else if (imc<25){
                System.out.println("IMC: " + imc + " " + IMC18_25);
            } else if (imc<30){
                System.out.println("IMC: " + imc + " " + IMC25_30);
            } else {
                System.out.println("IMC: " + imc + " " + IMCMAX_30);
            }
        } else {
            String mensaje="No se puede calcular el IMC";
            if (p == null) {
                mensaje="Persona no definida";
            }
            else {
                mensaje="Datos necesarios no definidos";
            }
            throw new NotCalculateException(mensaje);
        }
    }

}
